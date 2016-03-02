package com.example.idnert.kol_app;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private  Controller controller;
    private LayoutPersonalPref layoutPersonalPref;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private LayoutPersonalPref fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutPersonalPref = new LayoutPersonalPref();
        controller = new Controller(this, layoutPersonalPref);

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if (savedInstanceState==null) {
            setFragment(layoutPersonalPref);
        }
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent refresh= new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFragment(LayoutPersonalPref personalPref) {
        ft = fm.beginTransaction();

        ft.replace(R.id.content, personalPref);

        ft.commit();

    }
}
