package com.fellin.timbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.fellin.timbersong.R;

public class ChantPull extends BaseActivity {
  /** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  			  
	      setContentView(R.layout.chant);
	      TextView vTitle = (TextView)findViewById(R.id.showChantTitle);
	      TextView vLyrics = (TextView)findViewById(R.id.showChantText);
	      TextView vVideo = (TextView) findViewById(R.id.showChantLink);
	      
	      Intent i = getIntent();
	      String chantName = i.getStringExtra("chantName");
	      //Replace all non-printable Unicode characters
		  try {
			  List<Chant>chants = LoadChantsFromXML(this);
			  Chant chantClicked = findChant(chantName, chants);
			  
			  vTitle.setText(chantClicked.name);
			  vLyrics.setText(chantClicked.lyrics);
			  vVideo.setText(chantClicked.video);
		  } catch (XmlPullParserException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	}
	
	public Chant findChant(String chantName, List<Chant> chants) {
		for(Chant c: chants){
			if (chantName.equals(c.name)) {
				Log.d("TAG","WAS HERE REACHED?");
				return c;
			}
		}
		return new Chant("Woops!","Looks like this chant is bugged.\nPlease report it to the developer!",
				"dan@highwaterlabs.com");
	}
	
	public List<Chant> LoadChantsFromXML(Activity activity)
			throws XmlPullParserException, IOException {
	   Resources res = activity.getResources();
	   XmlResourceParser xpp = res.getXml(R.xml.all);
	   xpp.next();
	   int eventType = xpp.getEventType();
	   
	   String currentTag = "";
	   String name = "";
	   String video = "";
	   String lyrics = "";
	   
	   List<Chant> results = new ArrayList<Chant>();
	   
	   while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                currentTag = xpp.getName();
            } else if (eventType == XmlPullParser.TEXT) {
                if ("name".equals(currentTag)) {
                    name = xpp.getText();
                }
                if ("lyrics".equals(currentTag)) {
                    lyrics = xpp.getText();
                    lyrics = lyrics.replaceAll("(?m)\\t+","");
                    lyrics = lyrics.replaceAll("(?m)^\\s+","");
                }
                if ("video".equals(currentTag)) {
                    video = xpp.getText();
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                if ("chant".equals(xpp.getName())) {
                    results.add(new Chant(name, lyrics, video));
                    name = "";
                    lyrics = "";
                    video = "";
                }
            }
	        eventType = xpp.next();
	   }
	   return results;
	 }
	  
}