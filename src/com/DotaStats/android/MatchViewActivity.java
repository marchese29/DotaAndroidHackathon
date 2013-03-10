package com.DotaStats.android;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class MatchViewActivity extends Activity {

	// Widgets
	private Button returnHomeButton;
	private TableRow[] table;

	private String matchID;

	private JSONParser parser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_view_layout);
		Intent intent = getIntent();
		this.matchID = intent.getStringExtra("matchID");

		/*
		 * TODO: Create all of the JSON objects using the JSONParser class.
		 * Also, make sure the table has loaded correctly.
		 */

		setWidgets();
		setWidgets2();
		this.parser = new JSONParser(matchID);
		this.setDataFromPlayerList(parser.getPlayerList());

	}

	private void setWidgets() {
		this.returnHomeButton = (Button) findViewById(R.id.bReturnHome);

		/*
		 * Click listener for returnHomeButton
		 */
		this.returnHomeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MatchViewActivity.this,
						MainMenu.class);
				intent.putExtra("matchID", matchID);
				startActivity(intent);
			}
		});
	}

	private void setWidgets2() {
		this.table = new TableRow[10];
		this.table[0] = (TableRow) findViewById(R.id.trPlayer1Row);
		this.table[1] = (TableRow) findViewById(R.id.trPlayer2Row);
		this.table[2] = (TableRow) findViewById(R.id.trPlayer3Row);
		this.table[3] = (TableRow) findViewById(R.id.trPlayer4Row);
		this.table[4] = (TableRow) findViewById(R.id.trPlayer5Row);

		this.table[5] = (TableRow) findViewById(R.id.trPlayer6Row);
		this.table[6] = (TableRow) findViewById(R.id.trPlayer7Row);
		this.table[7] = (TableRow) findViewById(R.id.trPlayer8Row);
		this.table[8] = (TableRow) findViewById(R.id.trPlayer9Row);
		this.table[9] = (TableRow) findViewById(R.id.trPlayer10Row);
	}

	private void setDataFromPlayerList(List<Player> playerList) {
		for (int i = 0; i < 10; i++) {
			Player currentPlayer = playerList.get(i);
			List<Integer> playerStats = currentPlayer.getIntList();
			TextView playerName = (TextView) this.table[i].getVirtualChildAt(0);
			playerName.setText(currentPlayer.name);

			ImageView heroPicture = (ImageView) this.table[i]
					.getVirtualChildAt(1);
			try {
				heroPicture.setImageBitmap(new GetWebImage().execute(currentPlayer.HeroName).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

			for (int j = 2; j < 9; j++) {
				TextView view = (TextView) this.table[i].getVirtualChildAt(j);
				view.setText(playerStats.get(j - 2).toString());
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.finish();
	}

}

class GetWebImage extends AsyncTask<String, Void, Bitmap> {

	@Override
	protected Bitmap doInBackground(String... heroName) {
		URL url;
		Bitmap result = null;
		try {
			url = new URL(
					"http://dotawebapihackathon.apphb.com/content/heroportraits/"
							+ heroName[0].replace(' ', '_') + "_full.png");
			URLConnection connection = url.openConnection();
			HttpURLConnection HCon = (HttpURLConnection) connection;
			InputStream ins = ((URLConnection) HCon).getInputStream();
			result = BitmapFactory.decodeStream(ins);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
