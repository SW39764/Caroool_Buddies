package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carpool_buddy_sam.Vehicles.Bycicle;
import com.example.carpool_buddy_sam.Vehicles.Car;
import com.example.carpool_buddy_sam.Vehicles.HeliCopter;
import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;

//shows info about specific vehicle selected in recyclerview
public class specific_vehicle_info extends AppCompatActivity {

    //instance variables
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private LinearLayout linearLayout;

    Vehicle currentVehicle;

    private TextView model;
    private TextView capacity;
    private TextView basePrice;
    private TextView owner;
    private TextView weight;
    private TextView weightCapacity;
    private TextView range;
    private TextView maxAltitude;
    private TextView maxAirSpeed;
    private TextView vehicleType;

    private ImageView iconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //creates firebase instance
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        setContentView(R.layout.activity_specific_vehicle_info);

        linearLayout = findViewById(R.id.linearLayoutSpecificInfo);

        //gets extras that were bundled in recyclerview about what vehicle was selected
        Bundle extras = getIntent().getExtras();

        //adds fields that all vehicles have
        commonFields();

        //if correct data was passed in
        if(getIntent().hasExtra("id")){
            //get the id of the vehicle and load it into the doc variable for easy access
            String id = extras.getString("id");
            DocumentReference doc = firestore.collection(com.example.carpool_buddy_sam.Constants.VEHICLE_COLLECTION).document(id);

            //gets the vehicle from the database
            Task<DocumentSnapshot> query = doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                //waits until data was received as otherwise it will try to use the data before it is received
                 @Override
                 public void onSuccess(DocumentSnapshot documentSnapshot) {
                    System.out.println(documentSnapshot.get("vehicleType"));

                    //depending on what type of vehicle it is, it will create a new vehicle object and set the fields

                     if(documentSnapshot.get("vehicleType").equals("car")){
                        Car vehicle = documentSnapshot.toObject(Car.class);
                         currentVehicle = vehicle;
                         setCarFields(vehicle);
                    }
                    else if(documentSnapshot.get("vehicleType").equals("bike")){
                        Bycicle vehicle = documentSnapshot.toObject(Bycicle.class);
                        currentVehicle = vehicle;
                        setBikeFields(vehicle);

                     }
                    else if(documentSnapshot.get("vehicleType").equals("helicopter")){
                        HeliCopter vehicle = documentSnapshot.toObject(HeliCopter.class);
                         currentVehicle = vehicle;
                         setHeliCopterFields(vehicle);

                    }
                    else if(documentSnapshot.get("vehicleType").equals("segway")){
                        Segway vehicle = documentSnapshot.toObject(Segway.class);
                         currentVehicle = vehicle;
                         setSegwayFields(vehicle);

                    }
                 }

                 });

        }



    }

    //sets the fields that all vehicles have from parent class Vehicle
    public void commonFields() {
        linearLayout.removeAllViewsInLayout();

        model = new TextView(this);
        linearLayout.addView(model);

        capacity = new TextView(this);
        linearLayout.addView(capacity);

        basePrice = new TextView(this);
        linearLayout.addView(basePrice);

        owner = new TextView(this);
        linearLayout.addView(owner);

        vehicleType = new TextView(this);
        linearLayout.addView(vehicleType);

    }

    //sets the fields for a car
    public void setCarFields(Car vehicle) {
        range = new TextView(this);
        linearLayout.addView(range);




        model.setText("Model: " + vehicle.getModel());
        capacity.setText("Capacity: " + vehicle.getCapacity() + " out of which there are : " + vehicle.getOccupiedCapacity());
        basePrice.setText("Base Price: " + vehicle.getBasePrice());
        owner.setText("Owner: " + vehicle.getOwner());
        vehicleType.setText("Vehicle Type: " + vehicle.getVehicleType());
        range.setText("Range: " + vehicle.getRange());

        iconImageView = new ImageView(this);
        iconImageView.setImageResource(R.drawable.car);
        iconImageView.setScaleX(0.5f);
        iconImageView.setScaleY(0.5f);
        linearLayout.addView(iconImageView);



    }

    //sets the fields for a bike
    public void setBikeFields(Bycicle vehicle) {
        weight = new TextView(this);
        linearLayout.addView(weight);

        weightCapacity = new TextView(this);
        linearLayout.addView(weightCapacity);


        model.setText("Model: " + vehicle.getModel());
        capacity.setText("Capacity: " + vehicle.getCapacity() + " out of which there are : " + vehicle.getOccupiedCapacity());
        basePrice.setText("Base Price: " + vehicle.getBasePrice());
        owner.setText("Owner: " + vehicle.getOwner());
        vehicleType.setText("Vehicle Type: " + vehicle.getVehicleType());
        weight.setText("Weight: " + vehicle.getWeight());
        weightCapacity.setText("Weight Capacity: " + vehicle.getWeightCapacity());

        iconImageView = new ImageView(this);
        iconImageView.setImageResource(R.drawable.bike);
        iconImageView.setScaleX(0.5f);
        iconImageView.setScaleY(0.5f);
        linearLayout.addView(iconImageView);
    }

    //sets the fields for a helicopter
    public void setHeliCopterFields(HeliCopter vehicle) {
        maxAirSpeed = new TextView(this);
        linearLayout.addView(maxAirSpeed);

        maxAltitude = new TextView(this);
        linearLayout.addView(maxAltitude);


        model.setText("Model: " + vehicle.getModel());
        capacity.setText("Capacity: " + vehicle.getCapacity() + " out of which there are : " + vehicle.getOccupiedCapacity());
        basePrice.setText("Base Price: " + vehicle.getBasePrice());
        owner.setText("Owner: " + vehicle.getOwner());
        vehicleType.setText("Vehicle Type: " + vehicle.getVehicleType());
        maxAirSpeed.setText("Max Air Speed: " + vehicle.getMaxAirSpeed());
        maxAltitude.setText("Max Altitude: " + vehicle.getMaxAltitude());

        iconImageView = new ImageView(this);
        iconImageView.setImageResource(R.drawable.helicopter);
        iconImageView.setScaleX(0.5f);
        iconImageView.setScaleY(0.5f);
        linearLayout.addView(iconImageView);
    }

    //sets the fields for a plane
    public void setSegwayFields(Segway vehicle) {
        range = new TextView(this);
        linearLayout.addView(range);

        weightCapacity = new TextView(this);
        linearLayout.addView(weightCapacity);

        model.setText("Model: " + vehicle.getModel());
        capacity.setText("Capacity: " + vehicle.getCapacity() + " out of which there are : " + vehicle.getOccupiedCapacity());
        basePrice.setText("Base Price: " + vehicle.getBasePrice());
        owner.setText("Owner: " + vehicle.getOwner());
        vehicleType.setText("Vehicle Type: " + vehicle.getVehicleType());
        weightCapacity.setText("Weight Capacity: " + vehicle.getWeightCapacity());
        range.setText("Range: " + vehicle.getRange());

        iconImageView = new ImageView(this);
        iconImageView.setImageResource(R.drawable.segway);
        iconImageView.setScaleX(0.5f);
        iconImageView.setScaleY(0.5f);
        linearLayout.addView(iconImageView);
    }

    //when book button is clicked it will book one spot in the vehicle
    public void bookedPress(View view) {

        if(!getIntent().hasExtra("id")){
            return;
        }
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        DocumentReference doc = firestore.collection(com.example.carpool_buddy_sam.Constants.VEHICLE_COLLECTION).document(id);

        if((currentVehicle.getCapacity() - Integer.parseInt(currentVehicle.getOccupiedCapacity())) == currentVehicle.getCapacity()){
            Toast.makeText(this, "No more space available", Toast.LENGTH_SHORT).show();
            return;
        }

        //adds rider to the vehicle and sets it back to the database
        ArrayList<String> riderUIDs = currentVehicle.getRidersUIDs();
        riderUIDs.add(mAuth.getUid());

        currentVehicle.setRidersUIDs(riderUIDs);

        doc.set(currentVehicle);

        //go back to recycler view
        Intent intent = new Intent(this, vehiclesRecycler.class);
        startActivity(intent);
    }

}