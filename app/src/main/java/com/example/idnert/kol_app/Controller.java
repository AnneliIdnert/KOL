package com.example.idnert.kol_app;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by idnert on 2016-02-25.
 */
public class Controller {
    private MainActivity mainActivity;
    private DbHelper dbHelper;
    private AddExercis addExercis;
    private List<Exercis> showExcerises;
    private Exercis_details exercis_details;
    PersonalPrefActivity personalPref;

    public Controller(Context context) {
        dbHelper = new DbHelper(context);
    }

    public Controller(MainActivity mainActivity, AddExercis addExercis, Exercis_details exercis_details,
                      PersonalPrefActivity personalPref) {
        this.mainActivity = mainActivity;
        this.addExercis = addExercis;
        this.exercis_details = exercis_details;
        this.personalPref = personalPref;

        dbHelper = new DbHelper(mainActivity);
        dbHelper = new DbHelper(addExercis);

        this.personalPref.setController(this);
        this.addExercis.setController(this);
        this.exercis_details.setController(this);
    }


    public void data(String firstName, String lastName, String persoNo, String sex, String habit) {
        DbHelper dbHelper = new DbHelper(mainActivity);
        dbHelper.insertPersonalPref(firstName, lastName, persoNo, sex, habit);
    }

    public void dataExercisInstruction(String category, String header, String repetition, String time, String instruction) {
        Log.i("", "text: " + "test");

        DbHelper dbhelper = new DbHelper(addExercis);
        dbhelper.exercis(category, header, repetition, time, instruction);
    }

    public List<Exercis> getExercis(){

        showExcerises = dbHelper.getExercis();
        return  showExcerises;
    };
}
