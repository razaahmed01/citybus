package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView sl = (TextView) findViewById(R.id.signin_link);
        EditText f_name=(EditText) findViewById(R.id.fname);
        EditText l_name=(EditText) findViewById(R.id.lname);
        EditText email=(EditText) findViewById(R.id.email);
        EditText password=(EditText) findViewById(R.id.pass);
        Button signup   =(Button) findViewById(R.id.signup_btn) ;

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(signup.this,login.class);
                startActivity(ob);
                finish();
            }
        });




    }
}