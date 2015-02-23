package com.example.sor.balettakademinskalenderapp;

import java.util.ArrayList;

/**
 * Created by Sor on 2015-02-13.
 */
public class Section {
    int id;
    String sectionTitle;

    Course[] courses;

    public Section(int id, String title, Course[] list){
        this.id = id;
        sectionTitle = title;
        courses = list;
    }
}
