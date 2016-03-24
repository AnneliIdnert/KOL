package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by annikamagnusson on 24/03/16.
 */
public class PersonalPrefActivity extends Activity {
    private GoogleApiClient client;
    private Controller controller;
    private Button save;
    private EditText firstName;
    private EditText lastName;
    private EditText personNo;
    private CheckBox smoking;
    private Button inputExercis;
    private RadioButton man;
    private RadioButton woman;

    public PersonalPrefActivity() {
        // Required empty public constructor
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel_pref);

        save= (Button) findViewById(R.id.btnSavePersonalInfo);
        save.setOnClickListener(new addPersonalPref());

        firstName=(EditText) findViewById(R.id.firstname);
        lastName=(EditText) findViewById(R.id.lastname);
        personNo=(EditText) findViewById(R.id.edPersonno);
        man=(RadioButton) findViewById(R.id.rndButtnMan);
        woman=(RadioButton) findViewById(R.id.rndButtnFemale);
        smoking=(CheckBox) findViewById(R.id.cBoxSmoking);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_main:
                Intent main = new Intent(this, MainActivity.class);
                startActivity(main);
                return true;
            case R.id.action_exercis:
                Intent exercis = new Intent(this, AddExercis.class);
                startActivity(exercis);
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AddExercis Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AddExercis Page", // TODO: Define a title for the content shown.
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

    private class addPersonalPref implements View.OnClickListener {
        private Context activity;

        @Override
        public void onClick(View v) {
            String firstN = firstName.getText().toString();
            String lastN = lastName.getText().toString();
            String persNo = personNo.getText().toString();
            String sex= checkSex();
            String habit=smokingHabits();
//          Log.d("AI", controller.toString());
            Context context = getApplicationContext();
            DbHelper dbhelper = new DbHelper(context);
            dbhelper.exercis(firstN, lastN, persNo, sex, habit);
            //Intent intent = new Intent(this, MainActivity.class);
            //startActivity(intent);
        }

        public Context getActivity() {
            return activity;
        }

        private String checkSex() {
            if(woman.isChecked()) {
                return "Kvinna";
            } else if(man.isChecked()) {
                return "Man";
            }

            return "NA";
        }
    }

    private String smokingHabits() {
        if (smoking.isChecked()) {
            return "Röker";
        }

        return "Röker ej";
    }
}

