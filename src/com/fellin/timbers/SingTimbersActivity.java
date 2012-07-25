package com.fellin.timbers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fellin.timbersong.R;

public class SingTimbersActivity extends BaseActivity {
	private static final String TAG = "SingTimbersActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    
    }
    
     
    public void chantClickHandler(View v) {    	  	  	
    	Intent intent = new Intent(this, ChantPull.class);
    	Button b = (Button) v;
    	intent.putExtra("chantName", b.getText().toString());
    	startActivity(intent);
    	}
}