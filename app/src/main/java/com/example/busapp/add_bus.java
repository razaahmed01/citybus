package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class add_bus extends AppCompatActivity {

    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bus);
        dl = findViewById(R.id.drawer_addbus);
        EditText namebus=(EditText) findViewById(R.id.add_bus_txt);
        database db=new database(add_bus.this);
//        -----------------------------------------------------------
        RecyclerView busrecycler=(RecyclerView) findViewById(R.id.bushow);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        busrecycler.setLayoutManager(linearLayoutManager);
//        String[] buslist={"W12","W11"};

        ArrayList<busgetseter> busget=new ArrayList<busgetseter>();

        Cursor result=db.getAllBus();
        if(result.getCount()==0){
            Toast.makeText(this, "Do not have bus", Toast.LENGTH_SHORT).show();
        }
        while(result.moveToNext()){
            String bname=result.getString(result.getColumnIndex("name"));
            busget.add(new busgetseter(bname));
        }


        busadapter busadapter=new busadapter(add_bus.this,busget);
        busrecycler.setAdapter(busadapter);
//        -------------------------------------------------------------------

        findViewById(R.id.insert_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!(namebus.getText().toString().equals(""))){
                    boolean addbus=db.addbus(namebus.getText().toString());

                    Toast.makeText(add_bus.this, "SuccessFully Add Bus", Toast.LENGTH_SHORT).show();
                    namebus.setText("");

                }else {
                    Toast.makeText(add_bus.this, "Please Add Bus Name", Toast.LENGTH_SHORT).show();
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