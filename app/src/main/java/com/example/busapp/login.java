package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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
        Button btn = findViewById(R.id.login_btn);
        TextView  ll = findViewById(R.id.signup_link);
//        TextView  ex = findViewById(R.id.error);
        database db =new database(login.this);

//        try {
//            database dbc=new database(this);
//            ex.setText("Succefully created");
//        }catch (Exception e){
//
//            ex.setText("error"+e.toString());
//
//        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!(email.getText().toString().equals("") || pass.getText().toString().equals(""))) {

                        Cursor result = db.login(email.getText().toString(), pass.getText().toString(),"2");
                        Cursor res_admin = db.login(email.getText().toString(), pass.getText().toString(),"1");

                    if (result.getCount() == 0 && res_admin.getCount() == 0) {
                            Toast.makeText(login.this, "Failed", Toast.LENGTH_SHORT).show();
                            email.setText("");
                            pass.setText("");
                        } else if(res_admin.getCount() == 0 && result.getCount() != 0) {
                        Toast.makeText(login.this, "Successfully ", Toast.LENGTH_SHORT).show();
                        Intent ob = new Intent(login.this, home.class);
                        startActivity(ob);
                        finish();
                        email.setText("");
                        pass.setText("");

                        }
                    else{
                        Toast.makeText(login.this, "Successfully ", Toast.LENGTH_SHORT).show();
                        Intent ob = new Intent(login.this, admin_dashboard.class);
                        startActivity(ob);
                        finish();
                        email.setText("");
                        pass.setText("");
                    }

                }else {
                    Toast.makeText(login.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(login.this,signup.class);
                startActivity(ob);

            }
        });

    }



}