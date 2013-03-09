package com.DotaStats.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MatchViewActivity extends Activity {

	String matchID;

	// Widgets
	Button returnHomeButton;
	Button individualStatsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_view_layout);
		Intent intent = getIntent();
		this.matchID = intent.getStringExtra("matchID");

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
						/*
						 * TODO: Add true functionality to this button
						 */
						Toast.makeText(getApplicationContext(),
								"Stats button clicked", Toast.LENGTH_SHORT)
								.show();
					}
				});
	}

}
