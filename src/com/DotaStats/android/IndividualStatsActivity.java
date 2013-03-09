package com.DotaStats.android;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IndividualStatsActivity extends Activity {
	
	private JSONParser parser;
	private List<Player> playerList;
	private int currentIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.individual_stats_layout);
		Intent intent = getIntent();
		this.parser = new JSONParser(intent.getStringExtra("matchID"));
		this.playerList = parser.getPlayerList();
		setWidgets();
		populateData(0);
	}
	
	private void setWidgets() {
		
	}
	
	private void populateData(int index) {
		Player currentPlayer = playerList.get(index);
	}

}
