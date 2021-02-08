package com.example.sqliteoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class myDbManager {
    myDbHelper myhelper;
    public myDbManager(Context context) {
        myhelper = new myDbHelper(context);
    }
    public long insert(String name, String score) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.SCORE, score);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null ,
                contentValues);
        return id;
    }
    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper._ID,myDbHelper.NAME,myDbHelper.SCORE};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext()){
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper._ID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String password =cursor.getString(cursor.getColumnIndex(myDbHelper.SCORE));
            buffer.append(cid+ " " + name + " " + password +" \n");
        }
        return buffer.toString();
    }
}