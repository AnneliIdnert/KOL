package com.example.idnert.kol_app;

/**
 * Created by idnert on 2016-02-25.
 */
public class Controller {

    private MainActivity mainActivity;
    private LayoutPersonalPref layoutPersonalPref;
    private DbHelper dbHelper;
    private AddExercis addExercis;


    public Controller(MainActivity mainActivity, LayoutPersonalPref layoutPersonalPref, AddExercis addExercis) {
        this.layoutPersonalPref = layoutPersonalPref;
        this.mainActivity = mainActivity;
        this.addExercis = addExercis;

        dbHelper = new DbHelper(this.mainActivity);

        this.layoutPersonalPref.setController(this);
       // this.addExercis.setController(this);

    }

    public void data(String firstName, String lastName, String persoNo, String sex, String habit) {

        DbHelper dbHelper = new DbHelper(mainActivity);
        dbHelper.insertPersonalPref(firstName, lastName, persoNo,sex, habit );

    }

    public void setMainActivity(){mainActivity.setFragment(layoutPersonalPref);}
}
