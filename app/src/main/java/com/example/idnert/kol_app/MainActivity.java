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
import android.widget.Button;

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
    private static final String TAG = "MainActivity";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
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

        controller = new Controller(this, addExercis, exercis_details, pers_pref);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        switch (item.getItemId()) {
            /**case R.id.action_settings:
             Intent refresh= new Intent(this, MainActivity.class);
             startActivity(refresh);
             this.finish();
             return true;
             **/
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
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);

        final Button startExercise = (Button) findViewById(R.id.btnExercise);
        startExercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "You clicked Start Exercise");
            }
        });

        final Button statistics = (Button) findViewById(R.id.btnStatistics);
        statistics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "You clicked Statistics");
            }
        });

        final Button userInformation = (Button) findViewById(R.id.btnUserInformation);
        userInformation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "You clicked User Information");
            }
        });

        final Button addExercise = (Button) findViewById(R.id.btnAddExercise);
        addExercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "You clicked Add Exercise");
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
