#!/bin/bash

echo run setup
. .ca-jenkins-adapter-config/setup.sh

json="
{\"appLinkName\":\"$9\",
    \"fields\":
       {\"id\":\"$BUILD_TAG\",
        \"title\":\"Build $BUILD_NUMBER completed with status $3\",
        \"status\":\"New\",
		\"result\":\"$6\",
		\"start_date\":\"$7 $8\",
		\"end_date\":\"$(date +'%m/%d/%Y %H:%M:%S')\",
        \"priority\":\"major\",
        \"created_by\":\"vijay\",
        \"assigned_to\":\"vijay\",
        \"linked_story_id\":\"$5\",
        \"created_time\":\"$(date +'%m/%d/%Y %H:%M:%S')\",
        \"modified_date\":\"$(date +'%m/%d/%Y %H:%M:%S')\",
        \"BUILD_ID\":\"$BUILD_ID\",
        \"BUILD_DISPLAY_NAME\":\"$BUILD_DISPLAY_NAME\",
        \"JOB_NAME\":\"$JOB_NAME\",
        \"JOB_BASE_NAME\":\"$JOB_BASE_NAME\",
        \"BUILD_TAG\":\"$BUILD_TAG\",
        \"EXECUTOR_NUMBER\":\"$EXECUTOR_NUMBER\",
        \"NODE_NAME\":\"$NODE_NAME\",
        \"NODE_LABELS\":\"$NODE_LABELS\",
        \"JENKINS_URL\":\"$JENKINS_URL\",
        \"BUILD_URL\":\"$BUILD_URL\",
        \"JOB_URL\":\"$JOB_URL\",
        \"GIT_COMMIT\":\"$GIT_COMMIT\",
        \"GIT_PREVIOUS_COMMIT\":\"$GIT_PREVIOUS_COMMIT\",
        \"GIT_PREVIOUS_SUCCESSFUL_COMMIT\":\"$GIT_PREVIOUS_SUCCESSFUL_COMMIT\",
        \"GIT_BRANCH\":\"$GIT_BRANCH\",
        \"GIT_LOCAL_BRANCH\":\"$GIT_LOCAL_BRANCH\",
        \"GIT_URL\":\"$GIT_URL\",
        \"GIT_COMMITTER_NAME\":\"$GIT_COMMITTER_NAME\",
        \"GIT_AUTHOR_NAME\":\"$GIT_AUTHOR_NAME\",
        \"GIT_COMMITTER_EMAIL\":\"$GIT_COMMITTER_EMAIL\",
        \"GIT_AUTHOR_EMAIL\":\"$GIT_AUTHOR_EMAIL\"
        }}"
echo "Send JSON: $json"
echo "via ${ConnectAllUrl}/api/2/postRecord?apikey=$ConnectAllApikey"
curl \
--header "Content-Type: application/json;charset=UTF-8" -X POST \
-d "$json" \
 ${ConnectAllUrl}/connectall/api/2/postRecord?apikey=$ConnectAllApiKey
