package com.example.idnert.kol_app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class Exercis_details extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercis_details);
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
                Intent cardview = new Intent(this, CardViewActivity.class);
                startActivity(cardview);
                return true;
            case R.id.action_personalPref:
                Intent personalPref = new Intent(this, LayoutPersonalPref.class);
                startActivity(personalPref);
                return true;
            case R.id.action_listOfExercis:
                Intent listOfExercis = new Intent(this, RecyclerViewActivity.class);
                startActivity(listOfExercis);
                return true;


        }




        return super.onOptionsItemSelected(item);
    }

}
