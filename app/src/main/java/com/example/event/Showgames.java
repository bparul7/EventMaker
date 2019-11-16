package com.example.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Showgames extends AppCompatActivity {
    Database_Game_Table mydb;
    RecyclerView recyclerView;

    ArrayList<GetterSetter> a1=new ArrayList<>();
    String gid,gname,gsize;
    GameAdapter gameAdapter;
    private Paint p = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showgames);
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
         gameAdapter=new GameAdapter(this,a1,0);
        recyclerView.setAdapter(gameAdapter);





    }

}
