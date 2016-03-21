package com.example.idnert.kol_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewActivity extends Activity {

    private TextView header;
    private TextView description;
    private   ImageView image;
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
}
