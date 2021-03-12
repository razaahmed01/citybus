package com.example.busapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    static final String database="buses";
    static final int version    =1;
//    tables
    static final String bus     ="bus";
    static final String routes  ="route";
    static final String assign_route    ="assign_route";
//    bus table column
    static final  String b_id   ="id";
    static final  String b_name ="name";
//    route table name
    static final String r_id    ="id";
    static final String r_name  ="name";
//    assign_route
    static final String ar_id       ="id";
    static final String ar_bus_id   ="bus_id";
    static final String ar_route_id ="route_id";


    public database(@Nullable Context context) {
        super(context, database, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ bus +"("+b_id+" INTEGER PRIMARY KEY AUTOINCREMENT "+ b_name +" text)") ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+bus);
    }
}
