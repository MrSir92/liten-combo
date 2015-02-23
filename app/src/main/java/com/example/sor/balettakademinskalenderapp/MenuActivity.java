package com.example.sor.balettakademinskalenderapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MenuActivity extends ActionBarActivity {

    Course[] activeCourses;
    Section[] sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //instance Courses in Course Array
        activeCourses = new Course[9];

        for(int i = 0; i < 10; i++){
            activeCourses[i] = new Course(i, "Title", "StartDate", "Weekday", "För mycket");
        }

        //instance Sections in section array

        sections = new Section[2];

        for(int i = 0; i < 3; i++){
            sections[i] = new Section(i, "Section" + String.valueOf(i), activeCourses);
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
