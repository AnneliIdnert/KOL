package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddExercis extends Activity {

    private Controller controller;
    private MainActivity mainActivity;
    private Spinner choice;
    private EditText header;
    private EditText howMany;
    private EditText time;
    private EditText instruction;
    private Button save;
    private Button finsch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__exercis);

        choice = (Spinner)findViewById(R.id.chooseCategory);
        header = (EditText)findViewById(R.id.edHeader);
        howMany = (EditText)findViewById(R.id.edRepitions);
        time = (EditText)findViewById(R.id.edTime);
        instruction = (EditText)findViewById(R.id.edInstruction);
        save = (Button)findViewById(R.id.btnSave);
        save.setOnClickListener(new addExercis());
        finsch = (Button)findViewById(R.id.btnFinish);
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

    public void setController(Controller controller) {
        this.controller = controller;
    }


    private class addExercis implements View.OnClickListener {
        private Context activity;

        @Override
        public void onClick(View v) {
            String text = choice.getSelectedItem().toString();
            String inputHeader = header.getText().toString();
            String repetition = howMany.getText().toString();
            String getTime = time.getText().toString();
            String getInstruction = instruction.getText().toString();
            controller.dataExercisInstruction(text, inputHeader, repetition, getTime, getInstruction);
            Context context = getApplicationContext();
            Toast.makeText(getActivity(),
                    "Tack, om du vill lägga in en ny övning så går det bra! annars klicka på klar!", Toast.LENGTH_LONG).show();
        }

        public Context getActivity() {
            return activity;
        }
    }
}
