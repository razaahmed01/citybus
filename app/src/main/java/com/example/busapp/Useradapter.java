package com.example.busapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Useradapter extends BaseAdapter {
    Context c;
    ArrayList<usergetset> arrayList;
    LayoutInflater inflater;

    public Useradapter(Context c, ArrayList<usergetset> arrayList) {
        this.c = c;
        this.arrayList = arrayList;
        this.inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return  arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
