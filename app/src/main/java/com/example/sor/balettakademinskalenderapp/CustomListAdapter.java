package com.example.sor.balettakademinskalenderapp;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

    //Disables recycling of cells

    @Override

    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    //

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

            //Basic info
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


            //Detailed info
            TextView coursePeriodField = (TextView) v.findViewById(R.id.course_period_text_view);
            TextView courseTeacherField = (TextView) v.findViewById(R.id.course_teacher_text_view);
            TextView courseLengthField = (TextView) v.findViewById(R.id.course_length_text_view);
            TextView courseVacanciesField = (TextView) v.findViewById(R.id.course_vacancies_text_view);
            TextView courseDescriptionTitleField = (TextView) v.findViewById(R.id.course_descripitionTitle_text_view);
            TextView courseDescriptionField = (TextView) v.findViewById(R.id.course_descripition_text_view);

            if (coursePeriodField != null) {
                coursePeriodField.setText(String.format("Tid: " + p.getCoursePeriod()));
            }
            if (courseTeacherField != null) {
                courseTeacherField.setText(String.format("Lärare: " + p.getCourseTeacher()));
            }
            if (courseLengthField != null) {
                courseLengthField.setText(String.format("Antal veckor: " + p.getCourseLength()));
            }
            if (courseVacanciesField != null) {
                courseVacanciesField.setText(String.format("Platser kvar: " + p.getCourseVacancies()));
            }
            if (courseDescriptionTitleField != null) {
                courseDescriptionTitleField.setText(p.getCourseTitle());
            }
            if (courseDescriptionField != null) {
                courseDescriptionField.setText(p.getCourseDescription());
            }

        }

        return v;
    }

}
