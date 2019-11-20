package com.example.event;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class user_team extends SQLiteOpenHelper {
    public static final String DATABASE_1 = "REG.db";
    public static final String TABLE_1 = "user_team";
    public static final String col0 = "userid";
    public static final String col1 = "teamid";
    Context context1;


    public user_team(@Nullable Context context) {

        super(context, DATABASE_1, null, 2);
    }

    public int adddata(int uid, int tid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col0, uid);
        contentValues.put(col1, tid);

        long result = db.insert(TABLE_1, null, contentValues);
        if (result == -1)
            return 0;
        else
            return 1;
    }

    public ArrayList<Integer> query (int tid) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " +
                TABLE_1, null);

        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getInt(1) == (tid)) {
                        int ans = Integer.parseInt(data.getString(0));

                        arr.add(ans);
                    }
                }while (data.moveToNext());
            }
        }
        return arr;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE user_team(userid INTEGER,teamid INTEGER,UNIQUE(userid,teamid))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
