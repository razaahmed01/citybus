package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class add_bus extends AppCompatActivity {

    DrawerLayout dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bus);
        dl = findViewById(R.id.drawer_addbus);
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