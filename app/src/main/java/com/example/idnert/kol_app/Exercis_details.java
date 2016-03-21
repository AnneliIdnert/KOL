package com.example.idnert.kol_app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Exercis_details extends Activity {
    private Controller controller;
    private TextView header;
    private ImageView image;
    private TextView description;
    private TextView time;
    private Button startTime;
    private Button startmusic;
    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercis_details);

        header =(TextView)findViewById(R.id.exercis_header);
        image = (ImageView)findViewById(R.id.exercis_image);
        description = (TextView)findViewById(R.id.description);
        time = (TextView)findViewById(R.id.exercis_time);
        startTime = (Button)findViewById(R.id.btnTime);
        startTime.setOnClickListener(new timing());
        startmusic = (Button)findViewById(R.id.btnMusic);
        startmusic.setOnClickListener(new music());
        finish = (Button)findViewById(R.id.btnFinish);
        finish.setOnClickListener(new done());

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

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class timing implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    private class music implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    private class done implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            
        }
    }
}
