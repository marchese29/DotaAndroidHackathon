package com.DotaStats.android;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IndividualStatsActivity extends Activity {
	
	private JSONParser parser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.individual_stats_layout);
		Intent intent = getIntent();
		this.parser = new JSONParser(intent.getStringExtra("matchID"));
		populateData(parser.getPlayerList());
	}
	
	private void populateData(List<Player> playerList) {
		
	}

}
