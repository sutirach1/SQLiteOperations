package com.example.sqliteoperations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDbHelper extends SQLiteOpenHelper {
    // Database Information
    static final String DB_NAME = "MyDB";
    static final int DB_VERSION = 1;
    // Table Name
    public static final String TABLE_NAME = "MyTable";
    // Table columns
    public static final String _ID = "_id"; //(Primary Key)
    public static final String NAME = "name";
    public static final String SCORE = "score";
    // Creating table query
    private static final String CREATE_TABLE = "create table " +
            TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT NOT NULL, " + SCORE + " TEXT);";

    public myDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
