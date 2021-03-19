package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class admin_dashboard extends AppCompatActivity {

    DrawerLayout dl;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard2);
        dl = findViewById(R.id.drawer_layout);
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

    public void addbus(View v) {
        Intent ob = new Intent(admin_dashboard.this, add_bus.class);
        startActivity(ob);
    }

    public void addroute(View v) {
        Intent ob = new Intent(admin_dashboard.this, add_route.class);
        startActivity(ob);
    }

    public void assignroute(View v) {
        Intent ob = new Intent(admin_dashboard.this, assign_route.class);
        startActivity(ob);
    }

    public void showmember(View v) {
        Intent ob = new Intent(admin_dashboard.this, assign_route.class);
        startActivity(ob);
    }


}