package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class assign_route extends AppCompatActivity {
    DrawerLayout dl;
//    String[] Bus = {"Bus1", "Bus2", "Bus3"};
    String[] Route1 = {"Route1", "Route1", "Route1"};
    String[] Route2 = {"Route2", "Route2", "Route2"};
    Spinner add_bus,route1,route2;
//    String bus[],route_1[],route_2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assign_route);
        dl = (findViewById(R.id.drawer_assignroute));

        add_bus = (findViewById(R.id.bus));
        route1 = findViewById(R.id.route_one);
        route2 = findViewById(R.id.route_two);


//        ArrayAdapter<String> BusAdapter = new ArrayAdapter<String>(assign_route.this,);
//            add_bus.setAdapter(BusAdapter);
        ArrayAdapter<String> Route1Adapter = new ArrayAdapter<String>(assign_route.this,R.layout.support_simple_spinner_dropdown_item,Route1);
        route1.setAdapter(Route1Adapter);
        ArrayAdapter<String> Route2Adapter = new ArrayAdapter<String>(assign_route.this,R.layout.support_simple_spinner_dropdown_item,Route2);
        route2.setAdapter(Route2Adapter);
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

//    load sppiner data for buses

    private void loadSpinnerData() {
        // database handler
        database db = new database(getApplicationContext());

        // Spinner Drop down elements
//        List<String> buses = db.getAllBus();
//
//        // Creating adapter for spinner
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, buses);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter
//                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        add_bus.setAdapter(dataAdapter);
    }
}