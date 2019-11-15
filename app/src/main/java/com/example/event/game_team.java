package com.example.event;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class game_team extends SQLiteOpenHelper {
    public static final String DATABASE_1 = "teamGame.db";
    public static final String TABLE_1 = "game_team";
    public static final String col0 = "gameid";
    public static final String col1 = "teamid";

    public game_team(@Nullable Context context) {
        super(context, DATABASE_1, null, 2);
    }


    public int adddata(int gid, int tid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col0, gid);
        contentValues.put(col1, tid);

        long result = db.insert(TABLE_1, null, contentValues);
        if (result == -1)
            return 0;
        else
            return 1;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_1 + "("
                + col1 + " INTEGER," + col0 + " INTEGER"
                +" )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
