package com.example.sor.balettakademinskalenderapp;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

/**
 * Created by Sor on 2015-02-13.
 */
public class Course {

    int id;
    String courseTitle,
            courseDate,
            courseWeekdayTime,
            coursePrice;

    public Course(int id, String title, String date, String weekdayTime, String price){
        this.id = id;
        courseTitle = title;
        courseDate = date;
        courseWeekdayTime = weekdayTime;
        coursePrice = price;
    }

    int getId(){
        return id;
    }

    String getCourseTitle(){
        return courseTitle;
    }

    String getCourseDate(){
        return courseDate;
    }

    String getCourseWeekdayTime(){
        return courseWeekdayTime;
    }

    String getCoursePrice(){
        return coursePrice;
    }
}
