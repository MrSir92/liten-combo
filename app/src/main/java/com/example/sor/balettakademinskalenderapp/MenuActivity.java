package com.example.sor.balettakademinskalenderapp;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuActivity extends ActionBarActivity {

    ListView listView;

    Course[] activeCourses;
    Section[] sections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //instance Courses in Course Array
        activeCourses = new Course[9];

        for(int i = 0; i < 9; i++){
            activeCourses[i] = (new Course(i, "Title", "StartDate", "Weekday", "100kr",
                    "Ti 18:00-21:00", "Anna Andersson", "5", "20", "Afrikansk Dans innehåller " +
                    "traditionella, kraftfulla rörelser och expressiva danser. " +
                    "Det är mycket rörelser åt alla håll - som sträcker utåt, " +
                    "uppåt och samtidigt tungt ner mot jorden. " +
                    "Stilen passar både dig som har dansat en del och dig som är helt nybörjare."));
        }

        //instance Sections in section array

        sections = new Section[2];

        for(int i = 0; i < 2; i++){
            sections[i] = new Section(i, "Section" + String.valueOf(i), activeCourses);
        }
        listView = (ListView)findViewById(R.id.listView);

        CustomListAdapter listAdapter = new CustomListAdapter(getBaseContext(),
                R.layout.list_item_view, new ArrayList<Course>(Arrays.asList(activeCourses)));

        listView.setAdapter(listAdapter);

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
