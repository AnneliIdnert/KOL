package com.example.idnert.kol_app;

/**
 * Created by idnert on 2016-02-25.
 */
public class Controller {

    private MainActivity mainActivity;
    private LayoutPersonalPref layoutPersonalPref;
    private DbHelper dbHelper;


    public Controller(MainActivity mainActivity, LayoutPersonalPref layoutPersonalPref) {
        this.layoutPersonalPref = layoutPersonalPref;
        this.mainActivity = mainActivity;

        dbHelper = new DbHelper(this.mainActivity);

        this.layoutPersonalPref.setController(this);

    }

    public void data(String firstName, String lastName, String persoNo, String sex, String habit) {

        DbHelper dbHelper = new DbHelper(mainActivity);
        dbHelper.insertPersonalPref(firstName, lastName, persoNo,sex, habit );

    }

    public void setMainActivity(){mainActivity.setFragment(layoutPersonalPref);}
}
