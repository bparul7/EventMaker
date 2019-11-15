package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Showgames extends AppCompatActivity {
    Database_Game_Table mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showgames);
        mydb = new Database_Game_Table(this);

    }
}
