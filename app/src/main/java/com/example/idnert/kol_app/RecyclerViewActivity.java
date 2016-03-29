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


     //List<Exercis> exercises2= controller.getExercis();
        Context context = getApplicationContext();
        DbHelper dbhelper = new DbHelper(context);

        List<Exercis> exercises2= dbhelper.getExercis();



        String Category= exercises2.get(0).getCategory();
        String Description= exercises2.get(0).getDescription();
        String Header= exercises2.get(0).getHeader();
       // Log.i(TAG, "text: " + text);

        dbhelper.close();


        //Här ska listan initzieras se hur de var nedan. Men jag kan inte för mitt liv fatta hur jag ska få värderna till listan.
        //hittade denna länk som har gjort samma men jag får inte till de, du kan kolla på den https://github.com/khanal-abhi/todos/blob/master/app/src/main/java/co/khanal/todos/ListOfTodos.java

        exercises = new ArrayList<>();
        exercises.add(new Exercis("pro", "en mysig promenad, lyssna till det som händer runt dig...", R.drawable.walk));
        exercises.add(new Exercis("Dansa", "Ta en sväng om...", R.drawable.seniors_dance));
        exercises.add(new Exercis("Meditation", "En lugn och stilla minut för att öka närvaron", R.drawable.breading));
    }

    private void initializeAdapter() {
        RVAadapter adapter = new RVAadapter(exercises);
        rv.setAdapter(adapter);
    }


}
