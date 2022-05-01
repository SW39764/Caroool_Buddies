package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;

import java.util.ArrayList;

public class vehiclesRecycler extends AppCompatActivity {

    RecyclerView recView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_recycler);

        recView = findViewById(R.id.recView);



        ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
        Vehicle vehicle = new Segway("String owner", "String model", 12, "String vehicleID",
                null, true, "String vehicleType",
        12.2, 12, 321);
        vehiclesList.add(vehicle);



//        System.out.println("Just before creating adapter");
        vehiclesRecViewAdapter myAdapter = new vehiclesRecViewAdapter(vehiclesList);

//        System.out.println("Just before setting");
        recView.setAdapter(myAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

    }

}