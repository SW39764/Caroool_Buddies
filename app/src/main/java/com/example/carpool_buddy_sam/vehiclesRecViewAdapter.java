package com.example.carpool_buddy_sam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carpool_buddy_sam.Vehicles.Vehicle;

import java.util.ArrayList;

public class vehiclesRecViewAdapter extends RecyclerView.Adapter<vehicleRecyclerViewViewHolder>{

    ArrayList<Vehicle> vehicles;

    public vehiclesRecViewAdapter(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }





    @NonNull
    @Override
    public vehicleRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_row_view, parent, false);

        vehicleRecyclerViewViewHolder viewHolder = new vehicleRecyclerViewViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull vehicleRecyclerViewViewHolder holder, int position) {
        holder.vehicleInfo.setText(vehicles.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }
}
