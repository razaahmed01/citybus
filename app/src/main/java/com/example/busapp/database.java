package com.example.busapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public static String database ="bus";



    public database(@Nullable Context context) {
        super(context, database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE roles (id PRIMARY KEY AUTOINCREMENT , name text)");
            db.execSQL("CREATE TABLE regitration (id PRIMARY KEY AUTOINCREMENT , first_name text, last_name text, email text, password text, role INETGER," +
                    "FOREIGN KEY (role_id) REFERENCES roles(id))");
            db.execSQL("CREATE TABLE buses (id PRIMARY KEY AUTOINCREMENT , name text)");
            db.execSQL("CREATE TABLE routes (id PRIMARY KEY AUTOINCREMENT , name text)");
            db.execSQL("CREATE TABLE assign_routes (id PRIMARY KEY AUTOINCREMENT , route_id1 INTEGER, route_id2 INTERGER , bus_id INTEGER," +
                    "FOREIGN KEY (bus_id) REFERENCES buses(id)," +
                    "FOREIGN KEY (role_id) REFERENCES roles(id)," +
                    "FOREIGN KEY (route_id1) REFERENCES routes(id)," +
                    "FOREIGN KEY (route_id2) REFERENCES routes(id)" +
                    " )");

            
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS roles");
        db.execSQL("DROP TABLE IF EXISTS registration");
        db.execSQL("DROP TABLE IF EXISTS buses");
        db.execSQL("DROP TABLE IF EXISTS routes");
        db.execSQL("DROP TABLE IF EXISTS assign_routes");
    }

    public boolean insertuser(String f_name,String l_name,String email,String pwd){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("first_name", f_name);
            contentValues.put("last_name", l_name);
            contentValues.put("email", email);
            contentValues.put("password", pwd);
            contentValues.put("role", 1);
            long result =db.insert("regitration",null,contentValues);
            if(result ==-1) {
                return false;
            }
            else{
                return  true;
            }
    }
}
