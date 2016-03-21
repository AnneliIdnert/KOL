package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends Activity {

     TextView header;
     TextView description;
     TextView time;
     TextView repetition;
     ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kol__exercis);
        header=(TextView)findViewById(R.id.exercis_header);
        description=(TextView)findViewById(R.id.description);
        image = (ImageView)findViewById(R.id.exercis_image);

        header.setText("TA EN PROMIS");
        description.setText("När du tar en promenad kan du lyssna till allt ljud runt dig...");
        image.setImageResource(R.drawable.walk);

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
