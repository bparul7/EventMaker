package com.example.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class leaderboardAdapter extends RecyclerView.Adapter<leaderboardAdapter.MyClass>  {
    ArrayList<ModelL>a1;
    Context context;
    int st=0; //updated

    @NonNull
    @Override
    public leaderboardAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dummy, parent, false);
        return new leaderboardAdapter.MyClass(v);
    }

    public leaderboardAdapter(Context context, ArrayList<ModelL> a1,int val) {
        this.context=context;
        this.a1=a1;
        st=val;
    }

    @Override
    public void onBindViewHolder(@NonNull leaderboardAdapter.MyClass holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class MyClass extends RecyclerView.ViewHolder {
        TextView tname,score;
        public MyClass(View ItemView) {
            super(ItemView);
           tname=ItemView.findViewById(R.id.tname);
           score=ItemView.findViewById(R.id.tscore);


        }
    }
}