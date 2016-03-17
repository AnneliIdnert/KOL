package com.example.idnert.kol_app;

import android.app.Activity;
import android.os.Bundle;

import java.util.LinkedList;

public class RecyclerViewActivity extends Activity {
    private LinkedList<ShowExceris> showExcerises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
    }
}
