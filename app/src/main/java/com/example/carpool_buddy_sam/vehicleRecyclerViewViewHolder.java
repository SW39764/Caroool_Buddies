package com.example.carpool_buddy_sam;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class vehicleRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    protected TextView vehicleModel;
    protected TextView vehicleType;
    protected TextView vehicleCapacity;

    public vehicleRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);

        vehicleType = itemView.findViewById(R.id.vehicleType);
        vehicleModel = itemView.findViewById(R.id.vehicleModel);
        vehicleCapacity = itemView.findViewById(R.id.vehicleCapacity);
    }
}
