package com.fellin.timbers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.fellin.timbersong.R;


public class showChantActivity extends BaseActivity {
	private static final String TAG = "showChantActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			
			Integer chantId = 0;
			
			String chantTitle = "";
			String chantText = "";
			String chantLink = "";
			
			Intent i = getIntent();
			chantId = i.getIntExtra("chantId",1);
			
			setContentView(R.layout.chant);
			
			String[] chantLinkList = getResources().getStringArray(R.array.chantLink);
			
			
			TextView showChantTitle = (TextView) findViewById(R.id.showChantTitle);
			TextView showChantText = (TextView) findViewById(R.id.showChantText);
			TextView showChantLink = (TextView) findViewById(R.id.showChantLink);
			
			Log.d(TAG, String.valueOf(chantId));
			
			SimpleXmlPullApp sxp = new SimpleXmlPullApp(this); 
			
			
			switch (chantId) {
				case R.id.chantTitleBuryMe:
					chantTitle = getString(R.string.chantTitleBuryMe);
					chantText = getString(R.string.chantTextBuryMe);
					chantLink = chantLinkList[0];
					break;
				case R.id.chantTitleCantHelp:
					chantTitle = getString(R.string.chantTitleCantHelp);
					chantText = getString(R.string.chantTextCantHelp);
					chantLink = chantLinkList[1];
					break;
				case R.id.chantTitleWannaBe:
					chantTitle = getString(R.string.chantTitleWannaBe);
					chantText = getString(R.string.chantTextWannaBe);
					chantLink = chantLinkList[2];
					break;
				case R.id.chantTitleMentalBarmy:
					chantTitle = getString(R.string.chantTitleMentalBarmy);
					chantText = getString(R.string.chantTextMentalBarmy);
					chantLink = chantLinkList[3];
					break;
				case R.id.chantTitleMentalGreen:
					chantTitle = getString(R.string.chantTitleMentalGreen);
					chantText = getString(R.string.chantTextMentalGreen);
					chantLink = chantLinkList[4];
					break;
				case R.id.chantTitleMighty:
					chantTitle = getString(R.string.chantTitleMighty);
					chantText = getString(R.string.chantTextMighty);
					chantLink = chantLinkList[5];
					break;
				case R.id.chantTitleNorthEnd:
					chantTitle = getString(R.string.chantTitleNorthEnd);
					chantText = getString(R.string.chantTextNorthEnd);
					chantLink = chantLinkList[6];
					break;
				case R.id.chantTitleOnward:
					chantTitle = getString(R.string.chantTitleOnward);
					chantText = getString(R.string.chantTextOnward);
					chantLink = chantLinkList[7];
					break;
				case R.id.chantTitleParty:
					chantTitle = getString(R.string.chantTitleParty);
					chantText = getString(R.string.chantTextParty);
					chantLink = chantLinkList[8];
					break;
				case R.id.chantTitlePortlandBoys:
					chantTitle = getString(R.string.chantTitlePortlandBoys);
					chantText = getString(R.string.chantTextPortlandBoys);
					chantLink = chantLinkList[9];
					break;
				case R.id.chantTitleLoveYouSo:
					chantTitle = getString(R.string.chantTitleLoveYouSo);
					chantText = getString(R.string.chantTextLoveYouSo);
					chantLink = chantLinkList[10];
					break;
				case R.id.chantTitleWhoaOh:
					chantTitle = getString(R.string.chantTitleWhoaOh);
					chantText = getString(R.string.chantTextWhoaOh);
					chantLink = chantLinkList[11];
					break;
				case R.id.chantTitleSomos:
					chantTitle = getString(R.string.chantTitleSomos);
					chantText = getString(R.string.chantTextSomos);
					chantLink = chantLinkList[12];
					break;
				case R.id.chantTitleTetris:
					chantTitle = getString(R.string.chantTitleTetris);
					chantText = getString(R.string.chantTextTetris);
					chantLink = chantLinkList[13];
					break;
				case R.id.chantTitleWinTheLeague:
					chantTitle = getString(R.string.chantTitleWinTheLeague);
					chantText = getString(R.string.chantTextWinTheLeague);
					chantLink = chantLinkList[14];
					break;
				case R.id.chantTitleSunshine:
					chantTitle = getString(R.string.chantTitleSunshine);
					chantText = getString(R.string.chantTextSunshine);
					chantLink = chantLinkList[15];
					break;
			}
				
			showChantTitle.setText(chantTitle.toUpperCase());
			showChantText.setText(chantText);
			showChantLink.setText(chantLink);
			
			}
		catch (Exception e)	{
			// this is the line of code that sends a real error message to the log
			Log.e("ERROR", "ERROR IN CODE: " + e.toString());
	 
			// this is the line that prints out the location in
			// the code where the error occurred.
			e.printStackTrace();
		}
	}
}