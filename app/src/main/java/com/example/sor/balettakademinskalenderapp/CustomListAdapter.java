package com.example.sor.balettakademinskalenderapp;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sor on 2015-02-13.
 */
public class CustomListAdapter extends ArrayAdapter<ClipData.Item> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<ClipData.Item> items) {
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

        ClipData.Item p = getItem(position);

        if (p != null) {

            TextView courseTitleField = (TextView) v.findViewById(R.id.course_title_text_view);
            TextView courseDateField = (TextView) v.findViewById(R.id.course_date_text_view);
            TextView courseWeekdayTimeField = (TextView) v.findViewById(R.id.course_weekday_time_text_view);
            TextView coursePriceField = (TextView) v.findViewById(R.id.course_price_text_view);

            if (courseTitleField != null) {
                courseTitleField.setText(p.getId());
            }
            if (courseDateField != null) {

                courseDateField.setText(p.getCategory().getId());
            }
            if (courseWeekdayTimeField != null) {

                courseWeekdayTimeField.setText(p.getDescription());
            }
            if (coursePriceField != null){

            }
        }

        return v;

    }
