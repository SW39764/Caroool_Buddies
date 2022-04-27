package com.example.carpool_buddy_sam;

import static com.example.carpool_buddy_sam.AuthActivity.firestore;
import static com.example.carpool_buddy_sam.AuthActivity.mAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.carpool_buddy_sam.Users.User;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.example.carpool_buddy_sam.AuthActivity;

import java.util.ArrayList;

public class add_vehicle extends AppCompatActivity {

    private EditText vehicleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        vehicleName = findViewById(R.id.editTextName);
    }

    public void addVehicle(View v){
        System.out.println(vehicleName.getText().toString());

        ArrayList<String> riders = new ArrayList<>();
        String randId = "" + ((int) Math.random() * 1000);

        Vehicle vehicleToAdd;
        vehicleToAdd = new Vehicle(mAuth.getCurrentUser().toString(),
                "modelName", 3, randId, riders,
                true, "car", 124.1);

        firestore.collection("Vehicles").document("vehicle1").set(vehicleToAdd);
    }

}