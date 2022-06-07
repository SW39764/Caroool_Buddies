package com.example.carpool_buddy_sam;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class for recycler-view view holder
 */
public class vehicleRecyclerViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected TextView vehicleModel;
    protected TextView vehicleType;
    protected TextView vehicleCapacity;
    protected TextView vehicleBasePrice;

    protected ImageView icon;

    vehiclesRecViewAdapter.OnNoteListener onNoteListener;

    /**
     * Constructor for view holder
     * @param itemView View for the view holder
     * @param onNoteListener OnNoteListener for the view holder
     */
    public vehicleRecyclerViewViewHolder(@NonNull View itemView, vehiclesRecViewAdapter.OnNoteListener onNoteListener) {
        super(itemView);

        this.onNoteListener = onNoteListener;

        itemView.setOnClickListener(this);

        vehicleType = itemView.findViewById(R.id.vehicleType);
        vehicleModel = itemView.findViewById(R.id.vehicleModel);
        vehicleCapacity = itemView.findViewById(R.id.vehicleCapacity);
        vehicleBasePrice = itemView.findViewById(R.id.vehicleBasePrice);
        icon = itemView.findViewById(R.id.iconView);

    }

    /**
     * onClick method for the view holder
     * @param v View for the view holder
     */
    @Override
    public void onClick(View v) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }
}
