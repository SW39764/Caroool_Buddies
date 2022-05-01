package com.example.carpool_buddy_sam;

import static com.example.carpool_buddy_sam.AuthActivity.firestore;
import static com.example.carpool_buddy_sam.AuthActivity.mAuth;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carpool_buddy_sam.Vehicles.Bycicle;
import com.example.carpool_buddy_sam.Vehicles.Car;
import com.example.carpool_buddy_sam.Vehicles.HeliCopter;
import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class add_vehicle extends AppCompatActivity {

    private EditText vehicleName;
    private Spinner userRoleSpinner;
    private LinearLayout layout;
    private String uid;
    private static int uidGenerator = 1;
    private String selectedRole;

//    private EditText owner;
    private EditText model;
    private EditText capacity;
    private EditText basePrice;
    private EditText weight;
    private EditText weightCapacity;
    private EditText range;
    private EditText maxAltitude;
    private EditText maxAirSpeed;

    public int randInt(){
        return (int) (Math.random() * 100000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.linearLayoutAddVehicle);
        userRoleSpinner = findViewById(R.id.spinnerAddVehicle);
        setupSpinner();
        uid = "" + uidGenerator;
        uidGenerator++;

//        vehicleName = findViewById(R.id.editTextName);
    }

    public void addVehicle(View v){
        String id = "" + randInt();


//        System.out.println(vehicleName.getText().toString());

        ArrayList<String> riders = new ArrayList<>();
        String randId = "" + ((int) Math.random() * 1000);

        if(selectedRole.equals("Car")){
            Car vehicleToAdd = new Car("Owner", model.getText().toString(),
                    Integer.parseInt(capacity.getText().toString()),
            id, null, true, "car",
                    Double.parseDouble(basePrice.getText().toString()),
                    Integer.parseInt(range.getText().toString()));

            firestore.collection("Vehicles").document("vehicle" + id).set(vehicleToAdd);

        }

        if(selectedRole.equals("Bycicle")){
            Bycicle vehicleToAdd = new Bycicle("Owner", model.getText().toString(),
                    Integer.parseInt(capacity.getText().toString()),
                    id, null, true, "bike",
                    Double.parseDouble(basePrice.getText().toString()),
                    "modern", Integer.parseInt(weight.getText().toString()),
                    Integer.parseInt(weightCapacity.getText().toString()));

            firestore.collection("Vehicles").document("vehicle" + id).set(vehicleToAdd);
        }
        if(selectedRole.equals("Helicopter")){
            HeliCopter vehicleToAdd = new HeliCopter("Owner", model.getText().toString(),Integer.parseInt(capacity.getText().toString()),
                    id, null, true, "helicopter", Double.parseDouble(basePrice.getText().toString()),
                    Integer.parseInt(maxAltitude.getText().toString()), Integer.parseInt(maxAirSpeed.getText().toString()));


            firestore.collection("Vehicles").document("vehicle" + id).set(vehicleToAdd);
        }

        if(selectedRole.equals("Segway")){
            Segway vehicleToAdd = new Segway("Owner", model.getText().toString(),Integer.parseInt(capacity.getText().toString()),
                    id, null, true, "segway", Double.parseDouble(basePrice.getText().toString()), Integer.parseInt(range.getText().toString()),
                    Integer.parseInt(weightCapacity.getText().toString()));

            firestore.collection("Vehicles").document("vehicle" + id).set(vehicleToAdd);
        }






    }



    private void setupSpinner() {
        String[] userTypes = {"Bycicle", "Car", "Helicopter", "Segway"};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(add_vehicle.this,
                android.R.layout.simple_spinner_item, userTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userRoleSpinner.setAdapter(langArrAdapter);

        //triggered whenever user selects something different
        userRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedRole = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void addFields() {
        commonFields();
        if(selectedRole.equals("Bycicle")){
            weight = new EditText(this);
            weight.setHint("Weight");
            layout.addView(weight);

            weightCapacity = new EditText(this);
            weightCapacity.setHint("Weight Capacity");
            layout.addView(weightCapacity);
        }
        if(selectedRole.equals("Car")){
            range = new EditText(this);
            range.setHint("Range");
            layout.addView(range);
        }
        if(selectedRole.equals("Helicopter")){
            maxAltitude = new EditText(this);
            maxAltitude.setHint("Max Altitude");
            layout.addView(maxAltitude);

            maxAirSpeed = new EditText(this);
            maxAirSpeed.setHint("Max Air Speed");
            layout.addView(maxAirSpeed);
        }
        if(selectedRole.equals("Segway")){
            range = new EditText(this);
            range.setHint("Range");
            layout.addView(range);

            weightCapacity = new EditText(this);
            weightCapacity.setHint("Weight Capacity");
            layout.addView(weightCapacity);

        }

    }

    public void commonFields() {
        layout.removeAllViewsInLayout();
//        owner = new EditText(this);
//        owner.setHint("Owner");
//        layout.addView(owner);

        model = new EditText(this);
        model.setHint("Model");
        layout.addView(model);

        capacity = new EditText(this);
        capacity.setHint("Capacity");
        layout.addView(capacity);

        basePrice = new EditText(this);
        basePrice.setHint("Base Price");
        layout.addView(basePrice);


    }


}