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

    String coursePeriod,
            courseTeacher,
            courseLength,
            courseVacancies,
            courseDescription;

    public Course(int id, String title, String date, String weekdayTime, String price,
                  String period, String teacher, String length, String vacancies, String description){
        //Basic info
        this.id = id;
        courseTitle = title;
        courseDate = date;
        courseWeekdayTime = weekdayTime;
        coursePrice = price;

        //Detailed info
        coursePeriod = period;
        courseTeacher = teacher;
        courseLength = length;
        courseVacancies = vacancies;
        courseDescription = description;
    }

    int getId(){
        return id;
    }

    //Basic data
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

    //Detailed data
    String getCoursePeriod() { return  coursePeriod;}

    String getCourseTeacher() { return  courseTeacher; }

    String getCourseLength() { return  courseLength; }

    String getCourseVacancies() { return  courseLength; }

    String getCourseDescription() { return  courseDescription; }
 }
