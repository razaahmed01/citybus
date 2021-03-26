package com.example.busapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class busadapter extends RecyclerView.Adapter {

    @NonNull
    @NotNull
    ArrayList<busgetseter> busname;
    Context context;

    public busadapter(@NonNull  Context context,ArrayList<busgetseter> busname) {
        this.busname = busname;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.busshowlist,parent,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        busgetseter busgetset=busname.get(position);
        ((MyHolder) holder).bus_name.setText(busgetset.getBusname());
    }

    @Override
    public int getItemCount() {
        return busname.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView bus_name;
        public MyHolder(View item){
            super(item);
            bus_name=(TextView) item.findViewById(R.id.bus_name);

        }
    }
}
