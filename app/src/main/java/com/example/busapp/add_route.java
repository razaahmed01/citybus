package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class add_route extends AppCompatActivity {
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_route);
        dl = findViewById(R.id.drawer_addroute);
        EditText  r_name=(EditText) findViewById(R.id.route_name);
        Button insert=(Button) findViewById(R.id.route_insert);
//        --------------------------------------------------------------
        database db=new database(add_route.this);

        RecyclerView routerecycler=(RecyclerView) findViewById(R.id.routerecylerview);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        routerecycler.setLayoutManager(linearLayoutManager);

        ArrayList<routegetseter> routeget=new ArrayList<routegetseter>();

        Cursor result=db.getAllroute();
        if(result.getCount()==0){
            Toast.makeText(this, "Do not have route", Toast.LENGTH_SHORT).show();
        }
        while(result.moveToNext()){
            String rname=result.getString(result.getColumnIndex("name"));
            routeget.add(new routegetseter(rname));
        }


        routeapdapter routeapdapter=new routeapdapter(add_route.this,routeget);
        routerecycler.setAdapter(routeapdapter);

//        ----------------------------------------------------------------------

        insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!(r_name.getText().toString().equals(""))){
                boolean addroute=db.addroute(r_name.getText().toString());

                if(addroute == true) {
                    Toast.makeText(add_route.this, "Successfull", Toast.LENGTH_SHORT).show();
                    r_name.setText("");
                }else {
                    Toast.makeText(add_route.this, "Your data not insert", Toast.LENGTH_SHORT).show();
                }
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