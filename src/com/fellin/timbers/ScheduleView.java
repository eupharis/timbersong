package com.fellin.timbers;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.fellin.timbersong.R;

public class ScheduleView extends ListActivity {
	
	@Override	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		String[] gameList = getResources().getStringArray(R.array.home_game_array);
		
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gameList);
		setListAdapter(adapt);
		
	}
}