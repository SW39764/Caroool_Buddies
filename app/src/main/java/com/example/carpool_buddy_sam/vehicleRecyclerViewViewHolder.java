package com.example.carpool_buddy_sam;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class vehicleRecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected TextView vehicleModel;
    protected TextView vehicleType;
    protected TextView vehicleCapacity;
    protected TextView vehicleBasePrice;



    vehiclesRecViewAdapter.OnNoteListener onNoteListener;

    public vehicleRecyclerViewViewHolder(@NonNull View itemView, vehiclesRecViewAdapter.OnNoteListener onNoteListener) {
        super(itemView);

        this.onNoteListener = onNoteListener;

        itemView.setOnClickListener(this);

        vehicleType = itemView.findViewById(R.id.vehicleType);
        vehicleModel = itemView.findViewById(R.id.vehicleModel);
        vehicleCapacity = itemView.findViewById(R.id.vehicleCapacity);
        vehicleBasePrice = itemView.findViewById(R.id.vehicleBasePrice);

    }

    @Override
    public void onClick(View v) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }
}
