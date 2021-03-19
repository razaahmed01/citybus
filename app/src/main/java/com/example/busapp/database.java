package com.example.busapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public static String database ="bus.db";
    public static String roles ="roles";
    public static String register ="registration";
    public static String bus ="buses";
    public static String route ="routes";
    public static String assign_routes ="assign_route";



    public database(@Nullable Context context) {
        super(context, database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+register+" (id PRIMARY KEY AUTOINCREMENT , first_name text, last_name text, email text, password text)");
            
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
