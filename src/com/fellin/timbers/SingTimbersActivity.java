package com.fellin.timbers;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fellin.timbersong.R;

public class SingTimbersActivity extends BaseActivity {
	private static final String TAG = "SingTimbersActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    
    }
    
    public void chantClickHandler(View v) {
    	Intent intent = new Intent(this, showChantActivity.class);
    	intent.putExtra("chantId", v.getId());    	  	  	
    	Log.d(TAG, String.valueOf(v.getId()));
    	
    	startActivity(intent);
    	}
}