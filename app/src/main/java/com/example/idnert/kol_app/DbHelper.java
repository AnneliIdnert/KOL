package com.example.idnert.kol_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idnert on 2016-03-02.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "EXERCIS";
    public static final int DATABASE_VER = 4;

    public static final String TABLE_NAME = "PERSONAL_PREF";
    public static final String COLUMN_FIRST = "FIRSTNAME";
    public static final String COLUMN_LAST = "LASTNAME";
    public static final String COLUMN_PERSNUMBER = "PERSONNO";
    public static final String COLUMN_SEX = "SEX";
    public static final String COLUMN_HABITS = "SMOKING";

    public static final String TABLE_NAME_TWO = "EXERCIS";
    public static final String COLUMN_HEADER = "HEADER";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_REPETITION = "REPETITIONS";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_ID = "_id";

    public static final String TABLE_NAME_THREE = "STATISTIC";
    public static final String COLUMN_STATUS = "FEELING";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_DONE = "DONE";
    public static final String ID = "_id";

    public static final String CREATE_QUERY="CREATE TABLE "+TABLE_NAME+"("+COLUMN_FIRST+" text, "+COLUMN_LAST+" text, "+COLUMN_PERSNUMBER+" text, "+COLUMN_SEX+" text, "+COLUMN_HABITS+" text);";

    public static final String CREATE_QUERY_EXERCIS="CREATE TABLE "+TABLE_NAME_TWO+"("+COLUMN_ID+"_id INTEGER PRIMARY KEY AUTOINCREMENT," +COLUMN_HEADER+" text, "+COLUMN_DESCRIPTION+" text, "+COLUMN_REPETITION+" text, "+COLUMN_CATEGORY+" text, "+COLUMN_TIME+" text);";

    public static final String CREATE_QUERY_STATESTIC="CREATE TABLE "+TABLE_NAME_THREE+"(" +ID+"_id INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_STATUS+" text, "+COLUMN_DATE+" text, "+COLUMN_DONE+" INTEGER, FOREIGN KEY("+COLUMN_DONE+") REFERENCES TABLE_NAME_TWO(_id));";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);

        Log.d("DatabaseOperation", "Database is open...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);                                  // Creating the database table
        db.execSQL(CREATE_QUERY_EXERCIS);
        db.execSQL(CREATE_QUERY_STATESTIC);

        Log.d("Table is created", "table done");
    }

    public void insertPersonalPref(String firstName, String lastName, String persNo, String sex, String habit) {
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

    public void exercis(String category, String header, String repetition, String time, String instruction) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_HEADER, header);
        contentValues.put(COLUMN_DESCRIPTION, instruction);
        contentValues.put(COLUMN_REPETITION, repetition);
        contentValues.put(COLUMN_CATEGORY, category);
        contentValues.put(COLUMN_TIME, time);

        db.insert(TABLE_NAME_TWO, null, contentValues);
        Log.d("AI", db.toString());
    }
  /**  public Exercis [] getExercis(){
        int category, header, repetition, time, instruction;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM EXERCIS ", null);

        Exercis [] exercis = new Exercis[cursor.getCount()];
        category = cursor.getColumnIndex(COLUMN_CATEGORY);
        header = cursor.getColumnIndex(COLUMN_HEADER);
        repetition = cursor.getColumnIndex(COLUMN_REPETITION);
        time = cursor.getColumnIndex(COLUMN_TIME);
        instruction = cursor.getColumnIndex(COLUMN_DESCRIPTION);
        for (int i =0; i<exercis.length; i++){
            cursor.moveToPosition(i);
            exercis[i] = new Exercis(cursor.getString(category),
                    cursor.getString(header),
                    cursor.getString(repetition),
                    cursor.getString(time),
                    cursor.getString(instruction));
            Log.d("Get exercis ", "exercis queri");
        }
        return exercis;
    }**/
    public List<Exercis> getExercis(){
        List<Exercis> exercises = new ArrayList<Exercis>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM" + TABLE_NAME_TWO, null);
        cursor.moveToFirst();
        do {
            exercises.add(new Exercis(cursor.getInt(0),
                                      cursor.getString(1),
                                      cursor.getString(2),
                                      cursor.getString(3),
                                      cursor.getString(4),
                                      cursor.getString(5)));
        } while (cursor.moveToNext());

    cursor.close();
    return exercises;
        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME_TWO);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME_THREE);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
}
