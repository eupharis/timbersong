package com.fellin.timbers;

import com.fellin.timbersong.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

//This just implements a unified options menu across the whole app. 
public class BaseActivity extends Activity {
	@Override	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
