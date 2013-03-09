package com.DotaStats.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONParser {

	private JSONArray jsonArray;
	private String jsonString;
	private String matchID;

	public JSONParser(String matchID) {
		this.matchID = matchID;
		this.jsonString = getJSONFromAddress();

		try {
			this.jsonArray = new JSONArray(this.jsonString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getJSONFromAddress() {
		StringBuilder sb = new StringBuilder();
		
		try {
			DefaultHttpClient   httpclient = new DefaultHttpClient(new BasicHttpParams());
			HttpPost httppost = new HttpPost("http://someJSONUrl/jsonPlace.html");
			// Depends on your web service
			httppost.setHeader("Content-type", "application/json");
	
			InputStream inputStream = null;
			HttpResponse response = httpclient.execute(httppost);           
			HttpEntity entity = response.getEntity();
	
			inputStream = entity.getContent();
			// json is UTF-8 by default i beleive
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
			
	
			String line = null;
			while ((line = reader.readLine()) != null) {
			    sb.append(line + "\n");
			}
		} catch(ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
