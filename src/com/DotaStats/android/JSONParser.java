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

import android.os.AsyncTask;

public class JSONParser {

	private JSONArray jsonArray;
	private List<Player> playerList;

	public JSONParser(String matchID) {
		// String jsonString = getJSONFromMatchID(matchID);
		this.playerList = new ArrayList<Player>();
		try {
			this.jsonArray = new JSONArray(getJSONFromMatchID(matchID));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		/*
		 * Iterate through the array and create players. Add the players to the
		 * playerList.
		 */
		for (int i = 0; i < this.jsonArray.length(); i++) {

		}
		/*
		 * Create test data for now, TODO: Make this do actual work.
		 */
		this.playerList.add(new Player("Player1", 1, 1, 1, 1, 1, 1, 1));
		this.playerList.add(new Player("Player2", 2, 2, 2, 2, 2, 2, 2));
		this.playerList.add(new Player("Player3", 3, 3, 3, 3, 3, 3, 3));
		this.playerList.add(new Player("Player4", 4, 4, 4, 4, 4, 4, 4));
		this.playerList.add(new Player("Player5", 5, 5, 5, 5, 5, 5, 5));
		this.playerList.add(new Player("Player6", 6, 6, 6, 6, 6, 6, 6));
		this.playerList.add(new Player("Player7", 7, 7, 7, 7, 7, 7, 7));
		this.playerList.add(new Player("Player8", 8, 8, 8, 8, 8, 8, 8));
		this.playerList.add(new Player("Player9", 9, 9, 9, 9, 9, 9, 9));
		this.playerList.add(new Player("Player10", 10, 10, 10, 10, 10, 10, 10));

	}

	private String getJSONFromMatchID(String matchID) {
		String result = null;
		try {
			result = new WebTask()
					.execute(
							"http://api.steampowered.com/IDOTA2Match_570/GetMatch"
								+ "Details/V001/?match_id=143088168&key=84D99D637A497"
								+ "66C4725E98DE758BD4D").get();
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

class WebTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... arg0) {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(arg0[0]);
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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

}
