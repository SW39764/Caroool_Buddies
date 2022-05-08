package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class specific_vehicle_info extends AppCompatActivity {

//    TextView infoField;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private LinearLayout linearLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        setContentView(R.layout.activity_specific_vehicle_info);

        linearLayout = findViewById(R.id.linearLayoutSpecificInfo);

//        infoField = findViewById(R.id.vehicleInfo);

        Bundle extras = getIntent().getExtras();

        commonFields();

        if(getIntent().hasExtra("id")){
            String id = extras.getString("id");
            DocumentReference doc = firestore.collection(com.example.carpool_buddy_sam.Constants.VEHICLE_COLLECTION).document(id);


            Task<DocumentSnapshot> query = doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                 @Override
                 public void onSuccess(DocumentSnapshot documentSnapshot) {
                    System.out.println(documentSnapshot.get("vehicleType"));
                     if(documentSnapshot.get("vehicleType").equals("car")){
                        Car vehicle = documentSnapshot.toObject(Car.class);
                        setCarFields(vehicle);
                    }
                    else if(documentSnapshot.get("vehicleType").equals("bike")){
                        Bycicle vehicle = documentSnapshot.toObject(Bycicle.class);
                        setBikeFields(vehicle);

                     }
                    else if(documentSnapshot.get("vehicleType").equals("helicopter")){
                        HeliCopter vehicle = documentSnapshot.toObject(HeliCopter.class);
                        setHeliCopterFields(vehicle);

                    }
                    else if(documentSnapshot.get("vehicleType").equals("segway")){
                        Segway vehicle = documentSnapshot.toObject(Segway.class);
                        setSegwayFields(vehicle);

                    }
                 }

                 });

        }


    }

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

    public void setCarFields(Car vehicle) {
        range = new TextView(this);
        linearLayout.addView(range);




        model.setText("Model: " + vehicle.getModel());
        capacity.setText("Capacity: " + vehicle.getCapacity() + " out of which there are : " + vehicle.getOccupiedCapacity());
        basePrice.setText("Base Price: " + vehicle.getBasePrice());
        owner.setText("Owner: " + vehicle.getOwner());
        vehicleType.setText("Vehicle Type: " + vehicle.getVehicleType());
        range.setText("Range: " + vehicle.getRange());



    }

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
    }

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
    }

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
    }



}