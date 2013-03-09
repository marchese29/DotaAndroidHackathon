package com.DotaStats.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;

public class MainMenu extends Activity {

	Button matchSearchButton;
	EditText matchIdField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		setWidgets();
	}

	private void setWidgets() {
		this.matchSearchButton = (Button) findViewById(R.id.bMatchSearch);
		this.matchIdField = (EditText) findViewById(R.id.etMatchIdText);
		matchSearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String matchId = matchIdField.getText().toString();
				Intent intent = new Intent(MainMenu.this, MatchViewActivity.class);
				intent.putExtra("matchID", matchId);
				startActivity(intent);
			}
		});
	}

}
