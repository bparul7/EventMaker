package com.example.event;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class leaderboardAdapter extends RecyclerView.Adapter<leaderboardAdapter.MyClass>  {
    ArrayList<ModelL>a1;
    Context context;
    int st=0; //updated
    int id;

    @NonNull
    @Override
    public leaderboardAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dummy, parent, false);
        return new leaderboardAdapter.MyClass(v);
    }

    public leaderboardAdapter(Context context, ArrayList<ModelL> a1,int val,int id) {
        this.context=context;
        this.a1=a1;
        st=val;
        this.id=id;
    }

    @Override
    public void onBindViewHolder(@NonNull leaderboardAdapter.MyClass holder, int position) {
        final String name;
         final int tid;
        final ModelL g1=a1.get(position);
        holder.tname.setText(g1.getTname());
        tid=g1.getTid();
        holder.score.setText(String.valueOf(g1.getScore()));
        if(st==2){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CreateAlertDialog(tid);
                }
            });
        }
        else if (st == 3) {
            //team members name
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        TeamInfoDialogue(tid);
                }
            });
        }

    }

    public void TeamInfoDialogue(int tii) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        final user_team mydb = new user_team(context);
        arr = mydb.query(tii);
        final User_table mydb1 = new User_table(context);
        String final1 = "";
        for (int i=0; i<arr.size(); i++) {
            String temp = mydb1.query1(arr.get(i));
            final1=final1+temp+" , ";
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Participants");
        alert.setMessage("Names");
// Create TextView
        final TextView input = new TextView (context);
        input.setText(final1);
        alert.setView(input);
        alert.show();

    }

    public void CreateAlertDialog(final int tid) {
        final game_team mydb=new game_team(context);


        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);

        LinearLayout ll_alert_layout = new LinearLayout(context);
        ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
        final EditText ed_input = new EditText(context);
        ed_input.setHint("Enter Score");
        ll_alert_layout.addView(ed_input);

        alertbox.setTitle("Update Score");

        //setting linear layout to alert dialog

        alertbox.setView(ll_alert_layout);

        alertbox.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface arg0, int arg1) {

                        // will automatically dismiss the dialog and will do nothing

                    }
                });


        alertbox.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                        int score = Integer.parseInt(ed_input.getText().toString());

                        int res=mydb.updatedata(id,tid,score);
                        if (res == 0) {

                            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                        }
                        // do your action with input string

                    }
                });
        alertbox.show();
    }


    @Override
    public int getItemCount() {
        return a1.size();
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