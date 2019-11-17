package com.example.event;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User_table extends SQLiteOpenHelper {
    public static final String DATABASE_1 = "USER.db";
    public static final String TABLE_1 = "user_table";
    public static final String col1 = "UserName";
    public static final String col0 = "Id";
    public static final String col2 = "email";

    public User_table (@Nullable Context context) {
        super(context, DATABASE_1, null, 4);
    }

    public int adddata(String uname, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,uname);
        contentValues.put(col2,email);

        long result = db.insert(TABLE_1, null, contentValues);
        if (result == -1)
            return 0;
        else
            return 1;
    }
    public int query (String email) {
        int ans = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +
                        TABLE_1, null);
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getString(2).matches(email)) {
                        ans = Integer.parseInt(data.getString(0));
                        return ans;
                    }
                }while (data.moveToNext());
            }
        }
        return ans;
    }
    public String query1 (int uid) {
        String ans = "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +
                TABLE_1, null);
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getInt(0) == (uid)) {
                        ans = (data.getString(1));
                        return ans;
                    }
                }while (data.moveToNext());
            }
        }
        return ans;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_1 + "("
                + col0 + " INTEGER PRIMARY KEY AUTOINCREMENT," + col1 + " VARCHAR,"
                + col2 + " VARCHAR UNIQUE"+")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
