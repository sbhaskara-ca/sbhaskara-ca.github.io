
# Poll for new build requests, and kick off the builds
# Author: Doug Bass
# Copyright 2019 ConnectALL LLC

. .ca-jenkins-adapter-config/setup.sh

echo "-----------------------------------------"
if [ ! -f lasttime ]; then
	touch lasttime
fi

# Get the last time a poll was run and build the json request
lastRun="`date -r lasttime "+%Y-%m-%d %H:%M:%S" -u`.001"
#lastRun="2017-08-24 14:30:00.000"
echo Last run was $lastRun

json="
{\"appLinkName\":\"$1\",
 \"origin\":\"source\",
 \"lastModifiedTime\":\"$lastRun\"
}"

#Date must be in this format: 2017-08-24 14:30:00.000

echo "Send JSON: $json"
echo "via ${ConnectAllUrl}/api/2/search?apikey=$ConnectAllApiKey"

# Poll for any new build requests
curl \
--header "Content-Type: application/json;charset=UTF-8" -X POST \
-d "$json" \
 ${ConnectAllUrl}/connectall/api/2/search?apikey=$ConnectAllApiKey | tee request.json

touch lasttime
echo

# Parse out each build to run
totalrecords=0
totalrecords=`jq <request.json .totalrecords`
i=0
while [ $i -lt $totalrecords ]
do


#workspace=`cat request.json | sed -e 's/[{}]/''/g' | awk -v RS=',"' -F: '/workspace/ {print $2}' | sed -e 's/\"//g'`
workspace=`jq <request.json .data[$i].fields.workspace | sed -e 's/\"//g'`
workspace=CarlsCompany_Pipelinetest
echo
echo Workspace is $workspace

#artifact_id=`cat request.json |  sed -e 's/[{}]/''/g' | awk -v RS='[[]"' -F: '/id/ {print $2}' | sed -e 's/\"//g' | sed -e 's/,fields//g'`
artifact_id=`jq <request.json .data[$i].fields.linked_story_id | sed -e 's/\"//g'`

issuetype=`jq <request.json .data[$i].fields.issuetype | sed -e 's/\"//g'`

title=`jq <request.json .data[$i].title | sed -e 's/\"//g'`


echo
echo id is $artifact_id

# Send the build request to jenkins
if [ "$workspace" = "" ]; then
	echo "Nothing to build"
else
	wget --auth-no-challenge --http-user=dbass --http-password=g2gp4wd --secure-protocol=TLSv1 \
		${JenkinsUrl}/job/${workspace}/buildWithParameters?token=$JenkinsApiKey\&artifact_id=$artifact_id
fi


i=$(( $i + 1 ))

echo processed record number $i

done
