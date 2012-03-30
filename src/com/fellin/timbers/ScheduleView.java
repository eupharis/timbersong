package com.fellin.timbers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fellin.timbersong.R;


public class ScheduleView extends Activity {
	
	@Override	
	public void onCreate(Bundle savedInstanceState) {
		try
		{
			super.onCreate(savedInstanceState);
			ListView scheduleList;
			ArrayAdapter<String> adapt;
			
			setContentView(R.layout.schedule_list);
			scheduleList = (ListView) findViewById(R.id.scheduleList);
			
			String[] gameList = getResources().getStringArray(R.array.home_game_array);
			
			adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameList);
			scheduleList.setAdapter(adapt);
		}
		catch (Exception e)
		{
			// this is the line of code that sends a real error message to the log
			Log.e("ERROR", "ERROR IN CODE: " + e.toString());
	 
			// this is the line that prints out the location in
			// the code where the error occurred.
			e.printStackTrace();
		}
	}
}