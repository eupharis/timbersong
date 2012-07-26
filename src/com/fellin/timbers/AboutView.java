package com.fellin.timbers;

import android.os.Bundle;
import android.widget.TextView;

import com.fellin.timbersong.R;

public class AboutView extends BaseActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	
		TextView name_version = (TextView) findViewById(R.id.name_version);
		name_version.setText(getString(R.string.app_name) + " " + getString(R.string.version));
	}
}