package com.fellin.timbers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.fellin.timbersong.R;


public class showChantActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	Integer chantId;
	String chantTitle = "";
	String chantText = "";
	Intent i = getIntent();
	
	setContentView(R.layout.chant);
	
	TextView showChantTitle = (TextView) findViewById(R.id.showChantTitle);
	TextView showChantText = (TextView) findViewById(R.id.showChantText);
	
	
	chantId = i.getIntExtra("chantId",1);
	   
	switch (chantId) {
		case R.id.chantTitleBuryMe:
			chantTitle = getString(R.string.chantTitleBuryMe);
			chantText = getString(R.string.chantTextBuryMe);
			break;
		case R.id.chantTitleCantHelp:
			chantTitle = getString(R.string.chantTitleCantHelp);
			chantText = getString(R.string.chantTextCantHelp);
			break;
		case R.id.chantTitleMentalBarmy:
			chantTitle = getString(R.string.chantTitleMentalBarmy);
			chantText = getString(R.string.chantTextMentalBarmy);
			break;
		case R.id.chantTitleMentalGreen:
			chantTitle = getString(R.string.chantTitleMentalGreen);
			chantText = getString(R.string.chantTextMentalGreen);
			break;
		case R.id.chantTitleNorthEnd:
			chantTitle = getString(R.string.chantTitleNorthEnd);
			chantText = getString(R.string.chantTextNorthEnd);
			break;
		case R.id.chantTitleOnward:
			chantTitle = getString(R.string.chantTitleOnward);
			chantText = getString(R.string.chantTextOnward);
			break;
		case R.id.chantTitleParty:
			chantTitle = getString(R.string.chantTitleParty);
			chantText = getString(R.string.chantTextParty);
			break;
		case R.id.chantTitlePortlandBoys:
			chantTitle = getString(R.string.chantTitlePortlandBoys);
			chantText = getString(R.string.chantTextPortlandBoys);
			break;
		case R.id.chantTitleLoveYouSo:
			chantTitle = getString(R.string.chantTitleLoveYouSo);
			chantText = getString(R.string.chantTextLoveYouSo);
			break;
		case R.id.chantTitleSomos:
			chantTitle = getString(R.string.chantTitleSomos);
			chantText = getString(R.string.chantTextSomos);
			break;
		case R.id.chantTitleSunshine:
			chantTitle = getString(R.string.chantTitleSunshine);
			chantText = getString(R.string.chantTextSunshine);
			break;
		case R.id.chantTitleTetris:
			chantTitle = getString(R.string.chantTitleTetris);
			chantText = getString(R.string.chantTextTetris);
			break;
		case R.id.chantTitleWannaBe:
			chantTitle = getString(R.string.chantTitleWannaBe);
			chantText = getString(R.string.chantTextWannaBe);
			break;
		case R.id.chantTitleWhoaOh:
			chantTitle = getString(R.string.chantTitleWhoaOh);
			chantText = getString(R.string.chantTextWhoaOh);
			break;
		case R.id.chantTitleWinTheLeague:
			chantTitle = getString(R.string.chantTitleWinTheLeague);
			chantText = getString(R.string.chantTextWinTheLeague);
			break;
	}
		
	showChantTitle.setText(chantTitle.toUpperCase());
	showChantText.setText(chantText);
	
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
	    switch (item.getItemId()) {
		    case R.id.about:
		    	startActivity(new Intent(this,AboutView.class));
		    	return true;
		    case R.id.scheduleOption:
		    	startActivity(new Intent(this,ScheduleView.class));
		    	return true;
	    }
	    return super.onOptionsItemSelected(item);
    }
}