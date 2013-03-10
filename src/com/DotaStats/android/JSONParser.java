package com.DotaStats.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class JSONParser {

	private List<Player> playerList;
	
	public boolean hasFailed;

	public JSONParser(String matchID) {
		// String jsonString = getJSONFromMatchID(matchID);
		this.playerList = new ArrayList<Player>();
		this.hasFailed = false;
		try {
			AsyncResult result = getJSONFromMatchID(matchID);
			if (result.hasFailed()) {
				throw new Exception();
			}
			JSONObject json = new JSONObject(getJSONFromMatchID(matchID).getResult());
			JSONArray players = json.getJSONArray("players");

			/*
			 * Iterate through the players, creating objects for all ten of
			 * them.
			 */
			for (int i = 0; i < players.length(); i++) {
				playerList.add(new Player(players.getJSONObject(i)));
			}

		} catch (JSONException e) {
			e.printStackTrace();
			this.hasFailed = true;
		} catch (Exception e) {
			e.printStackTrace();
			this.hasFailed = true;
		}

	}

	private AsyncResult getJSONFromMatchID(String matchID) {
		AsyncResult result = null;
		try {
			result = new WebTask().execute(matchID).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}
}

class AsyncResult {
	private String result;
	private boolean error;
	
	public AsyncResult() {
		this.error = false;
		this.result = null;
	}
	
	public void setError(boolean value) {
		this.error = value;
	}
	
	public String getResult() {
		return result;
	}
	
	public boolean hasFailed() {
		return this.error;
	}
	
	public void setText(String text) {
		this.result = text;
	}
}

class WebTask extends AsyncTask<String, Void, AsyncResult> {

	@Override
	protected AsyncResult doInBackground(String... matchID) {
		AsyncResult result = null;
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(
				"http://dotawebapihackathon.apphb.com/api/matches/GetMatchDetails?matchId="
						+ matchID[0]);
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					content));
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result.setError(true);
		} catch (IOException e) {
			e.printStackTrace();
			result.setError(true);
		}
		
		if (result.hasFailed()) {
			result.setText(null);
		} else {
			result.setText(builder.toString());
		}
		
		return result;
		
		
	}

}
