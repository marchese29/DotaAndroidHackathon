package com.DotaStats.android;

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
		parser.getPlayerList();
		setWidgets();
		populateData(0);
	}
	
	private void setWidgets() {
		
	}
	
	private void populateData(int index) {
		
	}

}
