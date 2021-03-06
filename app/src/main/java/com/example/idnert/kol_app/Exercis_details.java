package com.example.idnert.kol_app;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.IOException;

public class Exercis_details extends Activity {
    private Controller controller;
    private TextView header;
    private ImageView image;
    private TextView description;
    private Button startTime;
    private Button startmusic;
    private Button finish;
    private StatisticActivity statisticActivity;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercis_details);

        header = (TextView) findViewById(R.id.exercis_header);
        image = (ImageView) findViewById(R.id.exercis_image);


        startTime = (Button) findViewById(R.id.btnTime);
        startTime.setOnClickListener(new timing());
        startmusic = (Button) findViewById(R.id.btnMusic);
        startmusic.setOnClickListener(new music());
        finish = (Button) findViewById(R.id.btnFinish);
        finish.setOnClickListener(new done());
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void finich(View view) {
        Intent intent = new Intent(this, StatisticActivity.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent refresh = new Intent(this, MainActivity.class);
                startActivity(refresh);
                this.finish();
                return true;
            case R.id.action_exercis:
                Intent cardview = new Intent(this, RecyclerView.class);
                startActivity(cardview);
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

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,
                "Exercis_details Page",
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
                "Exercis_details Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://com.example.idnert.kol_app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private class timing implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            Toast.makeText(context,
                    "Här sätts tiden igång, ej implementerad!", Toast.LENGTH_LONG).show();

        }
    }
    private class done implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Star.class);
            startActivity(intent);
        }
    }
    private class music implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            Toast.makeText(context,
                    "Här sätts musiken  på, ej implementerad!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
            startActivity(intent);
        }

    }
}


