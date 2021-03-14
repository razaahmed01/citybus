package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.email_input);
        EditText pass = findViewById(R.id.pass);
        Button btn = findViewById(R.id.Login_Btn);
        TextView  ll = findViewById(R.id.signup_link);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               email.setText("taha@gmail.com");
               pass.setText("aptech");

               Intent ob = new Intent(login.this,home.class);
               startActivity(ob);
               finish();
            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(login.this,signup.class);
                startActivity(ob);
                finish();


            }
        });

    }



}