package com.peterbateson.drivingquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperLogIn
{

    private DataBaseHelper dataBaseHelper;
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "userAccounts.db";
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text, PASSWORD text, HIGHSCORE1 text, HIGHSCORE2 text, HIGHSCORE3 text); ";
    public SQLiteDatabase database;
    private final Context key;


    public DatabaseHelperLogIn open() throws SQLException
    {
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        database.close();
    }


    public DatabaseHelperLogIn(Context userKey)
    {
        key = userKey;
        dataBaseHelper = new DataBaseHelper(key, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void insertUserDetails (String userName, String password)
    {
        ContentValues newUserDetails = new ContentValues();
        newUserDetails.put("USERNAME", userName);
        newUserDetails.put("PASSWORD",password);

        database.insert("LOGIN", null, newUserDetails);
    }

    public void insertUserScores (String highscore1, String highscore2, String highscore3)
    {
        ContentValues newUserScores = new ContentValues();
        newUserScores.put("HIGHSCORE1",highscore1);
        newUserScores.put("HIGHSCORE2",highscore2);
        newUserScores.put("HIGHSCORE3",highscore3);

        database.insert("LOGIN", null, newUserScores);

    }


    public String getUserDetails(String userName)
    {
        Cursor cursor = database.query("LOGIN", null, " USERNAME = ?", new String[]{userName}, null, null, null);

        if(cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public String getUserScores(String highscore1)
    {
        Cursor hs1 = database.query("LOGIN", null, "HIGHSCORE1 = ?", new String[]{highscore1}, null, null, null);
        return highscore1;
    }

    static class DataBaseHelper extends SQLiteOpenHelper
    {
        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase _db)
        {
            _db.execSQL(DATABASE_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
        {
            Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");

            _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
            onCreate(_db);
        }
    }
}

