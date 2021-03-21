package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_route extends AppCompatActivity {
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_route);
        dl = findViewById(R.id.drawer_addroute);
        EditText  r_name=(EditText) findViewById(R.id.route_name);
        Button insert=(Button) findViewById(R.id.route_insert);
        database db=new database(add_route.this);

        insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!(r_name.getText().toString().equals(""))){
                boolean addroute=db.addroute("name");
                Toast.makeText(add_route.this, "Successfull", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(add_route.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }




    public void ClickMenu(View v) {
        opendr(dl);
    }


    public void closedr(DrawerLayout drawer) {
        closedr(dl);
    }

    private static void opendr(DrawerLayout drawer) {
        drawer.openDrawer(GravityCompat.START);
    }
}