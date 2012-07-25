package com.fellin.timbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.fellin.timbersong.R;


public class ScheduleViewXml extends BaseActivity {
	
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
	        
	        gameListHome = (ListView) findViewById(R.id.gameListHome);
			List<Match> matches = LoadScheduleFromXML(this);
	        
			
		}
		catch (Exception e)	{
			Log.e("ERROR", "ERROR IN CODE: " + e.toString());
			e.printStackTrace();
		}
	}
		public List<Match> LoadScheduleFromXML(Activity activity)
        		throws XmlPullParserException, IOException {
    	   Resources res = activity.getResources();
    	   XmlResourceParser xpp = res.getXml(R.xml.all);
    	   xpp.next();
    	   int eventType = xpp.getEventType();
    	   
    	   String currentTag = "";
    	   String match_time = "";
    	   String opponent = "";
    	   Boolean atHome = false;
    	   
    	   List<Match> results = new ArrayList<Match>();
   			// TODO 
    	   
    	   while (eventType != XmlPullParser.END_DOCUMENT) {
               String TAG = "XMLPULLPARSER";  
    		   if (eventType == XmlPullParser.START_TAG) {
                    currentTag = xpp.getName();
                    if ("schedule".equals(currentTag)) {
                        if (xpp.getAttributeValue(null, "type").equals("home")) {
                        	Log.d(TAG,xpp.getAttributeValue(0));
                        	atHome = true;
                        	}
                        else atHome = false;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if ("date".equals(currentTag)) {
                    	match_time = xpp.getText();
                    }
                    if ("team".equals(currentTag)) {
                        opponent = xpp.getText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if ("item".equals(xpp.getName())) {
                        results.add(new Match(match_time, opponent, atHome));
                        Log.d(TAG,match_time);
                        Log.d(TAG,opponent);
                        Log.d(TAG,atHome.toString());
                    }
                }
    	        eventType = xpp.next();
    	   }
    	   return results;
    	 }

}