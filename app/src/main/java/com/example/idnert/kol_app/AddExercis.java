package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    private Button finsch;

    private static final String TAG = "AddExercise";
    public void setController(Controller controller) {this.controller = controller;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__exercis);

        mySpinner = (Spinner)findViewById(R.id.chooseCategory);
        //choice = (EditText)mySpinner.getSelectedItem();
        header = (EditText)findViewById(R.id.edHeader);
        howMany = (EditText)findViewById(R.id.edRepitions);
        time = (EditText)findViewById(R.id.edTime);
        instruction = (EditText)findViewById(R.id.edInstruction);
        save = (Button)findViewById(R.id.btnSave);
        save.setOnClickListener(new addExercis());
        finsch = (Button)findViewById(R.id.btnFinish);
        finsch.setOnClickListener(new done());


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


        switch (item.getItemId()){

            case  R.id.action_settings:
                Intent refresh= new Intent(this, MainActivity.class);
                startActivity(refresh);
                this.finish();
                return true;
            case R.id.action_exercis:
                Intent exercis = new Intent(this, AddExercis.class);
                startActivity(exercis);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }




    private class addExercis implements View.OnClickListener {
        private Context activity;

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
            controller.dataExercisInstruction(text, inputHeader, repetition, getTime, getInstruction);
            Context context = getApplicationContext();
            Toast.makeText(getActivity(),
                    "Tack, om du vill lägga in en ny övning så går det bra! annars klicka på klar!", Toast.LENGTH_LONG).show();
        }

        public Context getActivity() {
            return activity;
        }
    }

    private class done implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Intent intent = new Intent(this, kol_exercis.class);
          //  startActivity(intent);
        }
    }
}
