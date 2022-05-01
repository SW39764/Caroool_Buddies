package com.example.carpool_buddy_sam;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class vehicleRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    protected TextView vehicleInfo;

    public vehicleRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);

        vehicleInfo = itemView.findViewById(R.id.vehicleInfo);
    }
}
