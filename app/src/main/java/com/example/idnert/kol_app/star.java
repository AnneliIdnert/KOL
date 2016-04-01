package com.example.idnert.kol_app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Star extends Activity {

    private ImageButton star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        star = (ImageButton)findViewById(R.id.imgStar);
        star.setOnClickListener(new point());

    }



    private class point implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Point.class);
            startActivity(intent);
        }
    }

}
