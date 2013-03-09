package com.DotaStats.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MatchViewActivity extends Activity {
	
	String matchID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_view_layout);
		Intent intent = getIntent();
		this.matchID = intent.getStringExtra("matchID");
	}

}
