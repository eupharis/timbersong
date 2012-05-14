package com.fellin.timbers;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;

import com.fellin.timbersong.R;

 public class SimpleXmlPullApp  {

     public SimpleXmlPullApp(Context context)
         throws XmlPullParserException, IOException
     {
         String TAG = "SimpleXmlPullApp";
         Chant chant = new Chant();
         
         
         XmlResourceParser xpp = context.getResources().getXml(R.xml.chant_data);
         xpp.next();
         
         String property = ""; 
         //xpp.setInput(context.getResources().getXml(R.xml.strings_proper));
         //new StringReader ( "<foo>Hello World!</foo>" )
         int eventType = xpp.getEventType();
         while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_TAG) {
            	Log.d(TAG, xpp.getName());
            	xpp.next();
            	String data = xpp.getText();
            	Log.d(TAG, data);
              	/*if (property.equals("name")) {
              		Log.d(TAG, property);
              		xpp.next();
              		Log.d(TAG, xpp.getText());
              	}*/
            }
          /*} else if(eventType == XmlPullParser.TEXT) {
              Log.d(TAG, "Text "+xpp.getText());
          }*/
          eventType = xpp.next();
         }
         Log.d(TAG, "End document");
     }
     
 }