package com.example.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class UpdateScore extends AppCompatActivity {
    Database_Game_Table mydb;
    RecyclerView recyclerView;

    ArrayList<GetterSetter> a1=new ArrayList<>();
    String gid,gname,gsize;
    GameAdapter gameAdapter;
    private Paint p = new Paint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_score);
        mydb = new Database_Game_Table(this);
        recyclerView=findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Cursor data=mydb.getListContents1();
        if(data.getCount()>0){
            if(data.moveToFirst()){
                do{
                    gid=data.getString(0);
                    gname=data.getString(1);
                    gsize=data.getString(2);
                    Log.e("IDSS",gid+gname+gsize);

                    GetterSetter g1=new GetterSetter(gid,gname,gsize);
                    a1.add(g1);
                }while (data.moveToNext());
            }
        }
        gameAdapter=new GameAdapter(this,a1,2);
        recyclerView.setAdapter(gameAdapter);



    }
}
