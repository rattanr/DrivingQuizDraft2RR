package com.peterbateson.drivingquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 08-Jan-17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "HIGHSCORESTABLE";

    // Table name
    private static final String TABLE_NAME = "HIGHSCORES";

    // Score Table Columns names
    private static final String KEY_ID_SCORE = "_id";
    private static final String KEY_SCORE = "score_value";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID_SCORE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_SCORE + " TEXT" + ")";

        db.execSQL(CREATE_SCORE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    // Adding new score
    public void addScore(String score) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_SCORE, score); // score value

        // Inserting Values
        db.insert(TABLE_NAME, null, values);

        db.close();

    }

    // Getting All Scores
    public String[] getAllScores() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        int i = 0;

        String[] data = new String[cursor.getCount()];

        while (cursor.moveToNext()) {

            data[i] = cursor.getString(1);

            i = i++;

        }
        cursor.close();
        db.close();
        // return score array
        return data;
    }}
