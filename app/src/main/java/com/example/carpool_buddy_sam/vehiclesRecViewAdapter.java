package com.example.carpool_buddy_sam;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpool_buddy_sam.Vehicles.Vehicle;

import java.util.ArrayList;

public class vehiclesRecViewAdapter extends RecyclerView.Adapter<vehicleRecyclerViewViewHolder>{

//    ArrayList<Vehicle> vehicles;
//    ArrayList<String> type;
//    ArrayList<String> model;
//    ArrayList<Integer> capacity;

    ArrayList<Vehicle> vehicles;

    ImageView icon;

    private OnNoteListener mOnNoteListener;

    public vehiclesRecViewAdapter(ArrayList<Vehicle> vehicles, OnNoteListener monNoteListener) {
        this.vehicles = vehicles;
        this.mOnNoteListener = monNoteListener;
    }





    @NonNull
    @Override
    public vehicleRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_row_view, parent, false);

        vehicleRecyclerViewViewHolder viewHolder = new vehicleRecyclerViewViewHolder(view, mOnNoteListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull vehicleRecyclerViewViewHolder holder, int position) {
        String model = vehicles.get(position).getModel();
        String type = vehicles.get(position).getVehicleType();
        String capacity = "" + vehicles.get(position).getCapacity();
        String basePrice = "" + vehicles.get(position).getBasePrice();

        if(type.equals("car")){
            holder.icon.setImageResource(R.drawable.car);
            holder.icon.setScaleX(0.5f);
            holder.icon.setScaleY(0.5f);
        }
        else if(type.equals("bike")){
            holder.icon.setImageResource(R.drawable.bike);
            holder.icon.setScaleX(0.5f);
            holder.icon.setScaleY(0.5f);
        }
        else if(type.equals("segway")){
            holder.icon.setImageResource(R.drawable.segway);
            holder.icon.setScaleX(0.5f);
            holder.icon.setScaleY(0.5f);
        }
        else if(type.equals("helicopter")){
            holder.icon.setImageResource(R.drawable.helicopter);
            holder.icon.setScaleX(0.5f);
            holder.icon.setScaleY(0.5f);
        }

        holder.vehicleModel.setText("Model : " + model);
        holder.vehicleType.setText("Type : " + type);
        holder.vehicleCapacity.setText("Capacity : " + capacity);
        holder.vehicleBasePrice.setText("Base Price : " + basePrice);
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    public interface OnVehicleListener {
        void onVehicleClick(int position);

    }

}
