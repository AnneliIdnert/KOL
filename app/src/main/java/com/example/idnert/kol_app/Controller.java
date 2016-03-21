package com.example.idnert.kol_app;

import android.content.Context;

import java.util.LinkedList;

/**
 * Created by idnert on 2016-02-25.
 */
public class Controller {

     MainActivity mainActivity;
     LayoutPersonalPref layoutPersonalPref;
     DbHelper dbHelper;
     AddExercis addExercis;
     LinkedList<Exercis> showExcerises;

    public Controller(Context context) {

        dbHelper = new DbHelper(context);
    }
    public Controller(MainActivity mainActivity, LayoutPersonalPref layoutPersonalPref, AddExercis addExercis) {
        this.layoutPersonalPref = layoutPersonalPref;
        this.mainActivity = mainActivity;
        this.addExercis = addExercis;


        dbHelper = new DbHelper(mainActivity);

        this.layoutPersonalPref.setController(this);
        this.addExercis.setController(this);


    }

    public void data(String firstName, String lastName, String persoNo, String sex, String habit) {

        DbHelper dbHelper = new DbHelper(mainActivity);
        dbHelper.insertPersonalPref(firstName, lastName, persoNo, sex, habit);

    }

    public void setMainActivity(){mainActivity.setFragment(layoutPersonalPref);}

    public void dataExercisInstruction(String category, String header, String repetition, String time, String instruction) {
        DbHelper dbhelper = new DbHelper(mainActivity);
        dbhelper.exercis(category, header, repetition, time, instruction);
    }
}
