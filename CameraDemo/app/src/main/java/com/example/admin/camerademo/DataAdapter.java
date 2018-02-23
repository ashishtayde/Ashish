package com.example.admin.camerademo;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.text.TextDirectionHeuristic;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 20-12-2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    ArrayList<String> Strings;
    private TextView textView;
    public DataAdapter(ArrayList<BluetoothDevice> deviceName) {
        this.Strings=Strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.textView.setText(Strings.get(position));

    }

    @Override
    public int getItemCount() {
        return Strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.custom);

        }
    }
}