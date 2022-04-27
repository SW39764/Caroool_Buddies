package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VehicleInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
    }

    public void goToAddVehicle(View v) {
        Intent intent = new Intent(this, add_vehicle.class);
        startActivity(intent);
    }
}