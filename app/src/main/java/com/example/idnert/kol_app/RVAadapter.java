package com.example.idnert.kol_app;

import android.content.Context;
import android.content.Intent;
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
    private List<Exercis> exercises;

    public static class ExercisHolder extends RecyclerView.ViewHolder {
        private   CardView cardView;
        private   TextView header;
        private   TextView text;
        private   ImageView image;
        private   Exercis_details exercis_details;
        private   Context context;



        ExercisHolder(final View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.exercis_holder);
            header = (TextView)itemView.findViewById(R.id.exercis_header);
            text = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.exercis_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get listview position kolla!
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), Exercis_details.class));
                }
            });

        }
    }


    RVAadapter(List<Exercis> exercises) {
        this.exercises = exercises;
    }

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
        Exercis ex = exercises.get(i);
        exercisHolder.header.setText(ex.getHeader());
        exercisHolder.text.setText(ex.getDescription());
        exercisHolder.image.setImageResource(ex.getImage());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
