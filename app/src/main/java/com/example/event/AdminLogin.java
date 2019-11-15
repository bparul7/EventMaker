package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button login;
    EditText key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        key = findViewById(R.id.key);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.getText().toString().matches("apnst")) {
                    Intent intent = new Intent(AdminLogin.this, CommonActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(AdminLogin.this, "wrong key", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
