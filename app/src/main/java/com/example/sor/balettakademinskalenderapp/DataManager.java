package com.example.sor.balettakademinskalenderapp;

import android.content.Context;
import android.os.Environment;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 * Created by Sor on 2015-02-13.
 */
public class DataManager {
    public ArrayList<Course> activeCourses;



    public DataManager(){

    }

    public void Save(){
        final String xmlFile = "localDatabase";

        try {
            FileOutputStream fileos = new FileOutputStream (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "your_app_name" + "/" + "localDataBase.xml"));
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);

            for(int i = 0; i < activeCourses.size(); i++) {
                xmlSerializer.startTag(null, activeCourses.get(i).getCourseTitle());

                xmlSerializer.startTag(null, "id");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "id");

                xmlSerializer.startTag(null, "Date");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Date");

                xmlSerializer.startTag(null, "WeekDayTime");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "WeekDayTime");

                xmlSerializer.startTag(null, "Price");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Price");

                xmlSerializer.startTag(null, "Period");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Period");

                xmlSerializer.startTag(null, "Teacher");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Teacher");

                xmlSerializer.startTag(null, "Length");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Length");

                xmlSerializer.startTag(null, "Vacancies");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Vacancies");

                xmlSerializer.startTag(null, "Description");
                xmlSerializer.text(String.valueOf(activeCourses.get(i).getId()));
                xmlSerializer.endTag(null, "Description");

                xmlSerializer.endTag(null, activeCourses.get(i).getCourseTitle());
            }
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            String dataWrite = writer.toString();
            fileos.write(dataWrite.getBytes());
            fileos.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Load(Context c){
        final String xmlFile = "localDataBase";
        ArrayList<String> userData = new ArrayList<String>();
        FileInputStream fis;
        InputStreamReader isr;
        char[] inputBuffer;
        String data = new String();

        try {
            fis = c.openFileInput(xmlFile);
            isr = new InputStreamReader(fis);
            inputBuffer = new char[fis.available()];
            isr.read(inputBuffer);
            data = new String(inputBuffer);
            isr.close();
            fis.close();
        }
        catch (FileNotFoundException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
        }
        catch (XmlPullParserException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        factory.setNamespaceAware(true);
        XmlPullParser xpp = null;
        try {
            xpp = factory.newPullParser();
        }
        catch (XmlPullParserException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            xpp.setInput(new StringReader(data));
        }
        catch (XmlPullParserException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int eventType = 0;
        try {
            eventType = xpp.getEventType();
        }
        catch (XmlPullParserException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        while (eventType != XmlPullParser.END_DOCUMENT){
            if (eventType == XmlPullParser.START_DOCUMENT) {
                System.out.println("Start document");
            }
            else if (eventType == XmlPullParser.START_TAG) {
                System.out.println("Start tag "+xpp.getName());
            }
            else if (eventType == XmlPullParser.END_TAG) {
                System.out.println("End tag "+xpp.getName());
            }
            else if(eventType == XmlPullParser.TEXT) {
                userData.add(xpp.getText());
            }
            try {
                eventType = xpp.next();
            }
            catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String userName = userData.get(0);
        String password = userData.get(1);

    }

    public ArrayList<Course> Serialize(){
        return activeCourses;
    }
}
