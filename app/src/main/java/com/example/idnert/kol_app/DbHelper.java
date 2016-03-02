package com.example.idnert.kol_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by idnert on 2016-03-02.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "EXERCIS";
    public static final int DATABASE_VER = 1;

    public static final String TABLE_NAME = "PERSONAL_PREF";
    public static final String COLUMN_FIRST = "FIRSTNAME";
    public static final String COLUMN_LAST = "LASTNAME";
    public static final String COLUMN_PERSNUMBER = "PERSONNO";
    public static final String COLUMN_SEX = "SEX";
    public static final String COLUMN_HABITS = "SMOKING";

    public static final String TABLE_NAME_TWO = "EXERCIS";
    public static final String COLUMN_HEADER = "HEADER";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";



    public static final String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+"("+COLUMN_FIRST+" text, "+COLUMN_LAST+" text, "+COLUMN_PERSNUMBER+" text, "+COLUMN_SEX+" text, "+COLUMN_HABITS+" text);";

    public static final String CREATE_QUERY_EXERCIS="CREATE TABLE "+TABLE_NAME_TWO+"("+COLUMN_HEADER+" text, "+COLUMN_DESCRIPTION+" text);";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);

        Log.d("DatabaseOperation", "Database is open...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);                                  // Creating the database table
        db.execSQL(CREATE_QUERY_EXERCIS);

        Log.d("Table is created", "table done");
    }

    public void insertPersonalPref(String firstName, String lastName, String persNo, String sex, String habit){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST, firstName);
        contentValues.put(COLUMN_LAST, lastName);
        contentValues.put(COLUMN_PERSNUMBER, persNo);
        contentValues.put(COLUMN_SEX, sex);
        contentValues.put(COLUMN_HABITS, habit);

        db.insert(TABLE_NAME, null, contentValues);
        Log.d("AI", db.toString());
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME_TWO);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
}
