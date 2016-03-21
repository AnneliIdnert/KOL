package com.example.idnert.kol_app;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by idnert on 2016-03-18.
 */
public class RVAadapter extends RecyclerView.Adapter<RVAadapter.ExercisHolder> {

    public static class ExercisHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView header;
        TextView text;
        ImageView image;

        ExercisHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.exercis_holder);
            header = (TextView)itemView.findViewById(R.id.exercis_header);
            text = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.exercis_image);

        }
    }
    List<Exercis> exercises;
    RVAadapter(List<Exercis> exercises){this.exercises = exercises;}

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public ExercisHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_kol__exercis, viewGroup, false);
        ExercisHolder pvh = new ExercisHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ExercisHolder exercisHolder, int i) {
        exercisHolder.header.setText(exercises.get(i).header);
        exercisHolder.text.setText(exercises.get(i).description);
        exercisHolder.image.setImageResource(exercises.get(i).image);

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

}
