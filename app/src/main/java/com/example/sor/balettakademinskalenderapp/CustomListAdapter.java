package com.example.sor.balettakademinskalenderapp;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Sor on 2015-02-13.
 */
public class CustomListAdapter extends ArrayAdapter<Course> {

    public CustomListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CustomListAdapter(Context context, int resource, List<Course> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_item_view, null);

        }

        Course p = getItem(position);

        if (p != null) {

            TextView courseTitleField = (TextView) v.findViewById(R.id.course_title_text_view);
            TextView courseDateField = (TextView) v.findViewById(R.id.course_date_text_view);
            TextView courseWeekdayTimeField = (TextView) v.findViewById(R.id.course_weekday_time_text_view);
            TextView coursePriceField = (TextView) v.findViewById(R.id.course_price_text_view);

            if (courseTitleField != null) {
                courseTitleField.setText(p.getCourseTitle());
            }
            if (courseDateField != null) {

                courseDateField.setText(String.format("Datum: " + p.getCourseDate()));
            }
            if (courseWeekdayTimeField != null) {

                courseWeekdayTimeField.setText("Dag & Tid: " + p.getCourseWeekdayTime());
            }
            if (coursePriceField != null) {
                coursePriceField.setText("Pris: " + p.getCoursePrice());

            }
        }

        return v;

    }
}
