package com.example.busapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.text.BreakIterator;
import java.util.ArrayList;

public class routeapdapter extends RecyclerView.Adapter {
    @NonNull
    @NotNull
    ArrayList<routegetseter> routename;
    Context context;

    public routeapdapter(@NonNull  Context context,ArrayList<routegetseter> routename) {
        this.routename = routename;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.routeshowlist,parent,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        routegetseter routegetset=routename.get(position);
        ((MyHolder) holder).route_name.setText(routegetset.getRoutename());
    }

    @Override
    public int getItemCount() {
        return routename.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView route_name;
        public MyHolder(View item){
            super(item);
            route_name=(TextView) item.findViewById(R.id.route_name);

        }
    }
}
