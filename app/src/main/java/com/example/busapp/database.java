package com.example.busapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {

    public static String database ="bus";


    public database(@Nullable Context context) {
        super(context, database, null, 1);
//        just for checking database create or not
//        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE roles (id INTEGER PRIMARY KEY AUTOINCREMENT, name text)");
            db.execSQL("CREATE TABLE regitration (id INTEGER PRIMARY KEY AUTOINCREMENT, first_name text, last_name text, email text, password text, role_id INETGER,FOREIGN KEY (role_id) REFERENCES roles(id))");
            db.execSQL("CREATE TABLE buses (id INTEGER PRIMARY KEY AUTOINCREMENT , name text)");
            db.execSQL("CREATE TABLE routes (id INTEGER PRIMARY KEY AUTOINCREMENT , name text)");
            db.execSQL("CREATE TABLE assign_routes (id INTEGER PRIMARY KEY AUTOINCREMENT , route_id1 INTEGER, route_id2 INTEGER , bus_id INTEGER,String time," +
                    "FOREIGN KEY (bus_id) REFERENCES buses(id)," +
                    "FOREIGN KEY (route_id1) REFERENCES routes(id)," +
                    "FOREIGN KEY (route_id2) REFERENCES routes(id)" +
                    " )");
            db.execSQL("INSERT INTO roles (name) VALUES ('admin')");
            db.execSQL("INSERT INTO roles (name) VALUES ('client')");

//            db.execSQL("INSERT INTO regitration ('regitration')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS roles");
        db.execSQL("DROP TABLE IF EXISTS registration");
        db.execSQL("DROP TABLE IF EXISTS buses");
        db.execSQL("DROP TABLE IF EXISTS routes");
        db.execSQL("DROP TABLE IF EXISTS assign_routes");

        onCreate(db);
    }



    public boolean insertuser(String f_name,String l_name,String email,String pwd){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("first_name", f_name);
            contentValues.put("last_name", l_name);
            contentValues.put("email", email);
            contentValues.put("password", pwd);
            contentValues.put("role_id", 1);
            long result =db.insert("regitration",null,contentValues);
            if(result ==-1) {
                return false;
            }
            else{
                return  true;
            }
    }


    public Cursor login(String email,String password){
            SQLiteDatabase db =this.getWritableDatabase();
            Cursor result =db.rawQuery("SELECT * FROM regitration where email = ? AND password = ?",new String[]{email,password});
            return result;
    }

    //show user
    public Cursor getuser(){
        SQLiteDatabase db=this.getWritableDatabase();
       Cursor result= db.rawQuery("SELECT * FROM regitration",null);
        return result;
    }

    //add bus
    public boolean addbus(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        long result = db.insert("buses",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addroute(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        long result = db.insert("routes",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean assign_route(Integer bus,Integer route_1,Integer route_2,String time ){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("bus_id",bus);
        contentValues.put("route_id1",route_1);
        contentValues.put("route_id2",route_2);
        contentValues.put("time",time);

        long result=db.insert("assign_routes",null,contentValues);

        if(result == -1){
            return false;
        }else{
            return  true;
        }

    }


    public List<String> getAllBus(){
        List<String> buses=new ArrayList<String>();
        //select all buses
        String query="SELECT * FROM buses";

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        // loop through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                buses.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return buses;

    }

}
