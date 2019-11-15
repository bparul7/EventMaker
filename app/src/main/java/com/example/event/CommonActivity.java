package com.example.event;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CommonActivity extends AppCompatActivity {
    Button add,view;
    Database_Game_Table mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        mydb = new Database_Game_Table(this);
        add=findViewById(R.id.add);
        view=findViewById(R.id.view);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAlertDialog();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(CommonActivity.this, Showgames.class);
                startActivity(in);
            }
        });


    }
    public void CreateAlertDialog() {

        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

        LinearLayout ll_alert_layout = new LinearLayout(this);
        ll_alert_layout.setOrientation(LinearLayout.VERTICAL);
        final EditText ed_input = new EditText(this);
        final EditText ed_input1=new EditText(this);
        ed_input1.setHint("Enter Team Size");
        ed_input.setHint("Enter Game Name");
        ll_alert_layout.addView(ed_input1);
        ll_alert_layout.addView(ed_input);

        alertbox.setTitle("Add Games");

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

                        String name = ed_input.getText().toString();
                        String mx = ed_input1.getText().toString();
                        int res = mydb.adddata(name, Integer.valueOf(mx));
                        if (res == 0) {
                            Toast.makeText(CommonActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(CommonActivity.this, "success", Toast.LENGTH_SHORT).show();
                        }
                        // do your action with input string

                    }
                });
        alertbox.show();
    }
}
