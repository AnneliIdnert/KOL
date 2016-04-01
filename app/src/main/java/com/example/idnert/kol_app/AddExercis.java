package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class AddExercis extends Activity {

    Controller controller;
    CardViewActivity kol_exercis;
    MainActivity mainActivity;
    private Spinner mySpinner;
    private EditText choice;
    private EditText header;
    private EditText howMany;
    private EditText time;
    private EditText instruction;
    private Button save;
    private Button finish;

    private static final String TAG = "AddExercise";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__exercis);

        mySpinner = (Spinner) findViewById(R.id.chooseCategory);
        //choice = (EditText)mySpinner.getSelectedItem();
        header = (EditText) findViewById(R.id.edHeader);
        howMany = (EditText) findViewById(R.id.edRepitions);
        time = (EditText) findViewById(R.id.edTime);
        instruction = (EditText) findViewById(R.id.edInstruction);
        save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new addExercis());
        finish = (Button) findViewById(R.id.btnFinish);
        finish.setOnClickListener(new done());
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

    private class addExercis implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String text = mySpinner.getSelectedItem().toString();
            String inputHeader = header.getText().toString();
            String repetition = howMany.getText().toString();
            String getTime = time.getText().toString();
            String getInstruction = instruction.getText().toString();

            Log.i(TAG, "text: " + text);
            Log.i(TAG, "header: " + inputHeader);
            Log.i(TAG, "repetition: " + repetition);
            Log.i(TAG, "time: " + getTime);
            Log.i(TAG, "instruction: " + getInstruction);

            Context context = getApplicationContext();
            DbHelper dbhelper = new DbHelper(context);
            dbhelper.exercis(text, inputHeader, repetition, getTime, getInstruction);
            dbhelper.close();
            clearInput();
            Toast.makeText(context,
                    "Tack! om du vill lägga in en ny övning så går det bra! Annars klicka på klar!", Toast.LENGTH_LONG).show();
        }
    }
    private  void clearInput(){
        header.setText("");
        howMany.setText("");
        time.setText("");
        instruction.setText("");
    }
    private class done implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
             startActivity(intent);
        }
    }
}
