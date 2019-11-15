package com.example.event;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Game_Table extends SQLiteOpenHelper {
    public static final String DATABASE_1 = "GAME.db";
    public static final String TABLE_1 = "game_table";
    public static final String col0 = "Name";
    public static final String col1 = "Id";
    public static final String col3 = "Max_tem_size";

    public Database_Game_Table(@Nullable Context context) {
        super(context, DATABASE_1, null, 2);
    }

    public int adddata(String name, Integer mx) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col0, name);
        contentValues.put(col3, mx);

        long result = db.insert(TABLE_1, null, contentValues);
        if (result == -1)
            return 0;
        else
            return 1;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_1 + "("
                + col1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + col0 + " VARCHAR UNIQUE,"
                + col3 + " INTEGER"+" )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
