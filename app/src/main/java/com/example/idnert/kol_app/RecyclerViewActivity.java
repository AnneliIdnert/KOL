package com.example.idnert.kol_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {
     List<Exercis> exercises;
     RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        rv=(RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        exercises = new ArrayList<>();
        exercises.add(new Exercis("Promenad", "en mysig promenad, lyssna till det som händer runt dig...", R.drawable.walk));
        exercises.add(new Exercis("Dansa", "Ta en sväng om...", R.drawable.seniors_dance));
        exercises.add(new Exercis("Meditation", "En lugn och stilla minut för att öka närvaron", R.drawable.breading));
    }

    private void initializeAdapter() {
        RVAadapter adapter = new RVAadapter(exercises);
        rv.setAdapter(adapter);
    }
}
