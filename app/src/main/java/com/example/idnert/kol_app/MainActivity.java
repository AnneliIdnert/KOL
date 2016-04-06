package com.example.idnert.kol_app;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    private Controller controller;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private AddExercis addExercis;
    private DbHelper dbHelper;
    private Exercis_details exercis_details;
    private PersonalPrefActivity pers_pref;
    private StatisticActivity statisticActivity;
    private static final String TAG = "MainActivity";
    private GoogleApiClient client;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addExercis = new AddExercis();
        exercis_details = new Exercis_details();
        pers_pref = new PersonalPrefActivity();
        statisticActivity = new StatisticActivity();

        controller = new Controller(this, addExercis, exercis_details, pers_pref);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_main:
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                return true;
            case R.id.action_exercis:
                Intent exercise = new Intent(this, AddExercis.class);
                startActivity(exercise);
                return true;
            case R.id.action_personalPref:
                Intent personalPref = new Intent(this, PersonalPrefActivity.class);
                startActivity(personalPref);
                return true;
            case R.id.action_listOfExercis:
                Intent listOfExercis = new Intent(this, RecyclerViewActivity.class);
                startActivity(listOfExercis);
                return true;
            case R.id.action_statistics:
                Intent statistics = new Intent(this, StatisticActivity.class);
                startActivity(statistics);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();


        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void addExercise(View view) {
        Intent intent = new Intent(this, AddExercis.class);
        startActivity(intent);
    }

    public void startTraining(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
        Log.i(TAG, "You clicked Start training");
    }

    public void seeStatistics(View view) {
        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
        Log.i(TAG, "You clicked See Statistics");
    }

    public void userInformation(View view) {
        Intent intent = new Intent(this, PersonalPrefActivity.class);
        startActivity(intent);
    }
}
