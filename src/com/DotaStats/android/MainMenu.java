package com.DotaStats.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainMenu extends Activity {

	Button matchSearchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		setWidgets();
	}

	private void setWidgets() {
		this.matchSearchButton = (Button) findViewById(R.id.bMatchSearch);
		matchSearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						"Search Button Clicked", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
