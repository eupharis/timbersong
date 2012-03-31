package com.fellin.timbers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.fellin.timbersong.R;


public class ScheduleView extends Activity {
	
	@Override	
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			ListView gameListHome;
			ListView gameListAway;
			ArrayAdapter<String> adaptHome;
			ArrayAdapter<String> adaptAway;
			
			setContentView(R.layout.schedule_list);
			
	        // Set up the tabs
	        TabHost host = (TabHost) findViewById(R.id.TabHost1);
	        host.setup();
	        // Home Game List tab
	        TabSpec gameHomeTab = host.newTabSpec("homeTab");
	        
	        gameHomeTab.setIndicator(getResources().getString(R.string.home), getResources().getDrawable(R.drawable.ic_menu_home));
	        gameHomeTab.setContent(R.id.gameListHome);
	        host.addTab(gameHomeTab);
	        // Away Game tab
	        TabSpec gameAwayTab = host.newTabSpec("awayTab");
	        gameAwayTab.setIndicator(getResources().getString(R.string.away), getResources().getDrawable(android.R.drawable.ic_menu_myplaces));
	        gameAwayTab.setContent(R.id.gameListAway);
	        host.addTab(gameAwayTab);
	        // Set the default tab
	        host.setCurrentTabByTag("homeTab");
	        
			//Pull in the array of strings into gameListHome 
	        gameListHome = (ListView) findViewById(R.id.gameListHome);
			String[] homeList = getResources().getStringArray(R.array.home_game_array);
			
			adaptHome = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, homeList);
			gameListHome.setAdapter(adaptHome);
			
			//Pull in the array of strings into gameListAway 
			gameListAway = (ListView) findViewById(R.id.gameListAway);
			String[] awayList = getResources().getStringArray(R.array.away_game_array);
			
			adaptAway = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, awayList);
			gameListAway.setAdapter(adaptAway);
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