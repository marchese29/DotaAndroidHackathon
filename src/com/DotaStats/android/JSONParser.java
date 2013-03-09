package com.DotaStats.android;

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
		/*
		 * TODO: Fill in this method body.
		 */
		return null;
	}
}
