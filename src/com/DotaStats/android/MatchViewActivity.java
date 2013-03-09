package com.DotaStats.android;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MatchViewActivity extends Activity {

	// Widgets
	private Button returnHomeButton;
	private Button individualStatsButton;

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
		 */
		this.parser = new JSONParser(matchID);
		this.setDataFromPlayerList(parser.getPlayerList());

		/*
		 * TODO: Check to see that the match has loaded correctly.
		 */
		setWidgets();
	}

	private void setWidgets() {
		this.returnHomeButton = (Button) findViewById(R.id.bReturnHome);
		this.individualStatsButton = (Button) findViewById(R.id.bViewIndividuals);

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

		/*
		 * Click Listener for individualStatsButton
		 */
		this.individualStatsButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(MatchViewActivity.this, IndividualStatsActivity.class);
						intent.putExtra("matchID", matchID);
						startActivity(intent);
					}
				});
	}

	private void setDataFromPlayerList(List<Player> playerList) {
		/*
		 * TODO: Pull the player data and use it to populate the data table.
		 */
	}

}
