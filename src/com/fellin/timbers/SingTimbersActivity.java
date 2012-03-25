package com.fellin.timbers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.fellin.timbersong.R;

public class SingTimbersActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    
    }
    
    public void chantClickHandler(View v) {
    	Intent intent = new Intent(this, showChantActivity.class);
    	intent.putExtra("chantId", v.getId());    	  	  	
    	
    	startActivity(intent);
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