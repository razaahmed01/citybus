package com.example.busapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class show_member extends AppCompatActivity {
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_member);
        dl = (findViewById(R.id.drawer_showmember));
        Button showuser=(Button) findViewById(R.id.show);
        RecyclerView userli=(RecyclerView) findViewById(R.id.list);

        showuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database db=new database(show_member.this);
                Cursor userdata=db.getuser();
                if(userdata.getCount() == 0){
                    Toast.makeText(show_member.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                    return;
                }
//                StringBuffer sp=new StringBuffer();
//                while(userdata.moveToNext()){
//                sp.append(userdata.getString(userdata.getColumnIndex("last_name")));
//                }
//                Toast.makeText(show_member.this, sp.toString(), Toast.LENGTH_SHORT).show();
                ArrayList<usergetset> arrayList=new ArrayList<usergetset>();
                while(userdata.moveToNext()){
//                    arrayList.add(userdata.getString(userdata.getColumnIndex("last_name")));
                    String id_val=userdata.getString(userdata.getColumnIndex("id"));
                    String f_name_val=userdata.getString(userdata.getColumnIndex("first_name"));
                    String email_val=userdata.getString(userdata.getColumnIndex("email"));
                    arrayList.add(new usergetset(id_val,f_name_val,email_val));
                }
                    Useradapter useradapter=new Useradapter(show_member.this,arrayList);
                    userli.setAdapter(useradapter);


            }
        });
    }


    ArrayList<usergetset> user_list=new ArrayList<usergetset>();


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