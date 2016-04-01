package com.example.idnert.kol_app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Point extends Activity {
    private ImageView points;
    private Button backToExercis;
    private Button statistick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        points=(ImageView)findViewById(R.id.imgPoints);
        backToExercis = (Button)findViewById(R.id.btnExBack);
        backToExercis.setOnClickListener(new exercis());
        statistick = (Button)findViewById(R.id.btnStat);
        statistick.setOnClickListener(new viewStat());
    }

    private class exercis implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
    }

    private class viewStat implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), StatisticActivity.class);
            startActivity(intent);
        }
    }
}
