package com.example.sor.balettakademinskalenderapp;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

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
            activeCourses[i] = (new Course(i, "Balett för vuxna", "22 jan 2015", "To 20:00-21:15", "1650kr",
                    "To 20:00-21:15", "Anna Andersson", "5", "20", "Afrikansk Dans innehåller " +
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

        final CustomListAdapter listAdapter = new CustomListAdapter(getBaseContext(),
                R.layout.list_item_view, new ArrayList<Course>(Arrays.asList(activeCourses)));

        listView.setAdapter(listAdapter);

        //More Info Button in cell
/*
        findViewById(R.id.moreInfoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAdapter.loadExtra(v.getId(), v, (ViewGroup)v.getParent());
                listView.invalidate();
                listAdapter.notifyDataSetChanged();
            }
        });
        */

    }

    public void expandInfo(View v){

        //ListView list = (ListView)v.getParent();


        RelativeLayout relativeLayout = (RelativeLayout)v.getParent();

        View toolbar = relativeLayout.findViewById(R.id.toolbar);

        // Creating the expand animation for the item
        ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);

        // Start the animation on the toolbar
        toolbar.startAnimation(expandAni);

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
