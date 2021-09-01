package com.connectall.adapter.zabbix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectALLAPIConsumer {
	private final String CA_AUTH_USER = "admin";
	private final String CA_AUTH_PASS = "welcome";
	private final String CA_API_KEY = "";
	private final String CA_BASE_URI = "http://localhost:8090";
	private final String SAVE_RECORD_URI = "/connectall/api/2/postRecord";

	private Properties caProperties;

	private Logger log = LogManager.getLogger(ConnectALLAPIConsumer.class);

	/**
	 * PostRecord - consume the postrecord api of ConnectALL Universal adapter to
	 * create a record in the mapped destination
	 * 
	 * @param requestJson
	 * @throws Exception
	 */
	public void postRecord(final String requestJson) throws Exception {
		URL obj = new URL(resourceUri(SAVE_RECORD_URI));
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		String input = requestJson;

		String userCredentials = CA_AUTH_USER + ":" + CA_AUTH_PASS;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

		con.setRequestProperty("Authorization", basicAuth);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("apikey", CA_API_KEY);

		con.setDoInput(true);
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		int responseCode = con.getResponseCode();
		log.info("PostRecord API response code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK || responseCode == 201) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			log.info("PostRecord API response : " + response.toString());
		} else {
			log.info("PostRecord API request failed");
		}
	}

	private String resourceUri(String resourceUri) {
		return CA_BASE_URI + resourceUri;
	}

}
