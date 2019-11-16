package com.example.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class leaderboard extends AppCompatActivity {
    Database_Game_Table mydb;
    RecyclerView recyclerView;

    ArrayList<ModelL> a1=new ArrayList<ModelL>();
    String gid,gname,gsize;
    leaderboardAdapter leaderboardAdapter;
    private Paint p = new Paint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        mydb = new Database_Game_Table(this);
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Intent in=getIntent();
        String name;
        int id;
        name=in.getStringExtra("Name");
        id=in.getIntExtra("id",0);
        Cursor data=mydb.getListContents1();
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getInt(0) == id) {
                        int tname = data.getInt(1);
                        int score = data.getInt(2);
                        //find team name bt tid
                        team_table db1 = new team_table(getApplicationContext());
                        String tt = db1.query1(tname);
                        ModelL g1 = new ModelL(tt, score);
                        a1.add(g1);
                    }
                }while (data.moveToNext());
            }
        }
        leaderboardAdapter=new leaderboardAdapter(this,a1,0);
        recyclerView.setAdapter(leaderboardAdapter);
    }
}