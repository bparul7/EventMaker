package com.example.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class leaderboard extends AppCompatActivity {
    game_team mydb;
    RecyclerView recyclerView;
    TextView gname;

    ArrayList<ModelL> a1=new ArrayList<ModelL>();
    String gid,gsize;
    leaderboardAdapter leaderboardAdapter;
    private Paint p = new Paint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        //game id and team id and score
        mydb = new game_team(this);
        recyclerView=findViewById(R.id.recyclerview);
        gname=findViewById(R.id.gname);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Intent in=getIntent();
        String name;
        String id1;
        name=in.getStringExtra("Name");
        gname.setText(name);
        String stt = in.getStringExtra("prevst");

        id1=in.getStringExtra("id1");
        int id = Integer.valueOf(id1);
        Log.e("IDDDDDDD",String.valueOf(id));
        Cursor data= mydb.getListContents1();
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    if (data.getInt(0) == id) {
                        int tname = data.getInt(1);
                        int score = data.getInt(2);
                        Log.e("teamid and score", String.valueOf(tname) + String.valueOf(score));
                        //find team name bt tid
                        team_table db1 = new team_table(this);
                        String tt = db1.query1(tname);
                        Log.e("TEAM NMAE",String.valueOf(tt));
                        ModelL g1 = new ModelL(tt, score,tname);
                        a1.add(g1);
                    }
                }while (data.moveToNext());
            }
        }
        leaderboardAdapter=new leaderboardAdapter(this,a1,Integer.parseInt(stt),id);
        recyclerView.setAdapter(leaderboardAdapter);
    }
}