package com.example.idnert.kol_app;

/**
 * Created by idnert on 2016-03-17.
 */
public class Exercis {
    private Controller controller;
    private String category;
    private String header;
    private String description;
    private String time;
    private String repetition;
    private int image;
    private int id;

  public   Exercis(int id, String category, String header, String description, String time, String repetition) {
        this.id = id;
        this.category = category;
        this.header = header;
        this.description = description;
        this.time = time;
        this.repetition= repetition;
    }

 public   Exercis(String header, String description, int image) {
        this.header = header;
        this.description = description;
        this.image=image;
    }


    public int getId() {
        return id;
    }
    public String getCategory () {
        return category;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public String getRepetition() {
        return repetition;
    }
}

