package com.example.idnert.kol_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {
    private List<Exercis> exercises;
    private RecyclerView rv;
    private Controller controller;

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

        exercises.add(new Exercis("Promenad", "en mysig promenad, lyssna till det som händer runt dig, en promenad 30 min", R.drawable.walk));
        exercises.add(new Exercis("Styrketräning armar", "Ta dina hantlar och kör igång 10 x 3 repitioner ", R.drawable.arms));
        exercises.add(new Exercis("Benstyrka", "Djupa knaäböj 10 x 3 repitioner ", R.drawable.knee));
        exercises.add(new Exercis("Meditation", "En lugn och stilla minut för att öka närvaron 5 min", R.drawable.breading));
        exercises.add(new Exercis("Träna balans", "Enkla balansövningar för att få bättre närvaro 10 min", R.drawable.balance));
        exercises.add(new Exercis("Dansa", "Ta en sväng om, i 20 min", R.drawable.seniors_dance));
        exercises.add(new Exercis("Andningsövning", "Streacha din kropp i kombination med andning 15 min ", R.drawable.strech));
        exercises.add(new Exercis("Magövningar", "Träna magen 10 x 3 repitioner ", R.drawable.stomech));


    }


    private void initializeAdapter() {
        RVAadapter adapter = new RVAadapter(exercises);
        rv.setAdapter(adapter);
    }


}
