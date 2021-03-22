package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_bus extends AppCompatActivity {

    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bus);
        dl = findViewById(R.id.drawer_addbus);
        EditText namebus=(EditText) findViewById(R.id.add_bus_txt);
        database db=new database(add_bus.this);

        findViewById(R.id.insert_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(namebus.getText().toString().equals(""))){
                    boolean addbus=db.addbus("namebus");
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