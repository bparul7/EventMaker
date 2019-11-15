package com.example.event;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyClass> {
    ArrayList<GetterSetter>a1;
    Context context;


    public GameAdapter(Context context, ArrayList<GetterSetter> a1) {
        this.context=context;
        this.a1=a1;
    }


    @NonNull
    @Override
    public GameAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_view, parent, false);
        return new MyClass(v);
    }



    @Override
    public void onBindViewHolder(@NonNull GameAdapter.MyClass holder, int position) {
        GetterSetter g1=a1.get(position);
        holder.gid.setText(g1.getGid());
        holder.gname.setText(g1.getGname());
        holder.gsize.setText(g1.getGsize());
        Log.e("GETTER",g1.getGid()+g1.getGname()+g1.getGsize());


    }



    @Override
    public int getItemCount() {
        return a1.size();
    }

    public class MyClass extends RecyclerView.ViewHolder {
        TextView gid, gname, gsize;
        public MyClass(View ItemView) {
            super(ItemView);
            gid = ItemView.findViewById(R.id.gid);
            gname = ItemView.findViewById(R.id.gname);
            gsize = ItemView.findViewById(R.id.gsize);


        }
    }
}



