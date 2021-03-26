package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        Button signup   =(Button) findViewById(R.id.login_btn) ;
        database db=new database(signup.this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(!(f_name.getText().toString().equals("") || l_name.getText().toString().equals("") || email.getText().toString().equals("") || password.getText().toString().equals(""))){

                        boolean userinsert =db.insertuser(f_name.getText().toString(),l_name.getText().toString(),email.getText().toString(),password.getText().toString());
                        if(userinsert == true) {
                            Toast.makeText(signup.this, "Successfully", Toast.LENGTH_SHORT).show();
                            Intent ob = new Intent(signup.this, login.class);
                            startActivity(ob);

                            f_name.setText("");
                            l_name.setText("");
                            email.setText("");
                            password.setText("");

                            finish();
                        }else{
                            f_name.setText("");
                            l_name.setText("");
                            email.setText("");
                            password.setText("");
                            Toast.makeText(signup.this, "Your data not insert", Toast.LENGTH_SHORT).show();
                        }
                    }else {

                        Toast.makeText( signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                    }
            }
        });


        sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(signup.this,login.class);
                startActivity(ob);

            }
        });





    }
}