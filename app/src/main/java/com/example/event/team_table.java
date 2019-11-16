package com.example.event;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class team_table extends SQLiteOpenHelper {
    public static final String DATABASE_1 = "TEAM.db";
    public static final String TABLE_1 = "team";
    public static final String col1 = "teamname";
    public static final String col0 = "teamid";

    public team_table(@Nullable Context context) {
        super(context, DATABASE_1, null, 2);
    }

    public int query (String tname) {
        int ans = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_1 , null);
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getString(1).matches(tname)) {
                        ans = Integer.parseInt(data.getString(0));
                        return ans;
                    }
                }while (data.moveToNext());
            }
        }
        return ans;
    }

    public int adddata(String tname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1, tname);

        long result = db.insert(TABLE_1, null, contentValues);
        if (result == -1)
            return 0;
        else
            return 1;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_1 + "("
                + col0 + " INTEGER PRIMARY KEY AUTOINCREMENT," + col1 + " VARCHAR UNIQUE"
                +" )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
