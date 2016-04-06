package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    private RadioButton man;
    private RadioButton woman;

    public PersonalPrefActivity() {
        
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


        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "AddExercis Page",
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
                "AddExercis Page",
                Uri.parse("http://host/path"),

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
            clearInput();
            dbhelper.insertPersonalPref(firstN, lastN, persNo, sex, habit);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        private void clearInput(){
            firstName.setText("");
            lastName.setText("");
            personNo.setText("");


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

