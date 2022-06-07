package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.flatbuffers.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class for vehicleinfo activity
 * Allows users to chose where to navigae to next
 */
public class VehicleInfo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);

    }

    //go to add different activities

    /**
     * onClick method - when a user clicks the button, it will go to the add vehicle activity
     * @param v View for button
     */
    public void goToAddVehicle(View v) {
        Intent intent = new Intent(this, add_vehicle.class);
        startActivity(intent);
    }

    /**
     * onClick method - when a user clicks the button, it will go to the vehicleRecycler activity
     * @param v View for button
     */
    public void gotoRecyclerView(View v) {
        Intent intent = new Intent(this, vehiclesRecycler.class);
        startActivity(intent);
    }


}