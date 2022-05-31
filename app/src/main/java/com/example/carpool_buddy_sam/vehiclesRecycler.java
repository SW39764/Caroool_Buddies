package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carpool_buddy_sam.Vehicles.Bycicle;
import com.example.carpool_buddy_sam.Vehicles.Car;
import com.example.carpool_buddy_sam.Vehicles.HeliCopter;
import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

//recyclerview that displays all vehicles available to the user
public class vehiclesRecycler extends AppCompatActivity implements vehiclesRecViewAdapter.OnNoteListener, AdapterView.OnItemSelectedListener {

    //instance variables
    private RecyclerView recView;
    private Spinner spinner;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private ArrayList<Vehicle> vehiclesList;

    static public ArrayList<Vehicle> finishedList;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_recycler);

        vehiclesList = new ArrayList<Vehicle>();

        finishedList = new ArrayList<Vehicle>();

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        recView = findViewById(R.id.recView);

        //sets up spinner
        spinner = findViewById(R.id.spinner);
        ArrayList<String> spinnerList = new ArrayList<String>();
        spinnerList.add("No Filter");
        spinnerList.add("Bike");
        spinnerList.add("Car");
        spinnerList.add("Segway");
        spinnerList.add("Helicopter");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);

        //gets vehicles from database, and subsequently adds them to the recycler view
        getVehicles();

    }

    public void CreateAdapter(ArrayList<Vehicle> vehiclesList) {

        vehiclesRecViewAdapter myAdapter = new vehiclesRecViewAdapter(vehiclesList, this);

        recView.setAdapter(myAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getVehicles(){
        TaskCompletionSource<String> getAllRidesTask = new TaskCompletionSource<>();
        firestore.collection(com.example.carpool_buddy_sam.Constants.VEHICLE_COLLECTION).whereEqualTo("open", true)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    for (QueryDocumentSnapshot document : task.getResult()) {

                        String type = "" +  document.get("vehicleType");
//                        System.out.println(document.get("vehicleType"));

                        if (type.equals("segway")){
                            System.out.println("Added : " + document.toObject(Segway.class));

                            Vehicle temp = (Vehicle) (document.toObject(Segway.class));

                            finishedList.add(temp);

//                            ownerList.add(temp.getOwner());
//                            typeList.add(temp.getVehicleType());
//                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("car")){
                            System.out.println("Added : " + document.toObject(Car.class));

                            Vehicle temp = (Vehicle) (document.toObject(Car.class));

                            finishedList.add(temp);
//
//                            ownerList.add(temp.getOwner());
//                            typeList.add(temp.getVehicleType());
//                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("helicopter")){
                            System.out.println("Added : " + document.toObject(HeliCopter.class));
                            Vehicle temp = (Vehicle) (document.toObject(HeliCopter.class));

                            finishedList.add(temp);
//
//                            ownerList.add(temp.getOwner());
//                            typeList.add(temp.getVehicleType());
//                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("bike")){
                            System.out.println("Added : " + document.toObject(Bycicle.class));
                            Vehicle temp = (Vehicle) (document.toObject(Bycicle.class));

                            finishedList.add(temp);
//
//                            ownerList.add(temp.getOwner());
//                            typeList.add(temp.getVehicleType());
//                            capacityList.add(temp.getCapacity());
                        }

//                        System.out.println("Added a vehicle" + (Vehicle) document.toObject(Vehicle.class));
//                        vehiclesList.add((Vehicle) document.toObject(Vehicle.class));


                    }
                    getAllRidesTask.setResult(null);
                }
                else {
                    Log.d("VehiclesInfoActivity", "Error getting documents from db: ", task.getException());
                }
            }
        });
        // when all rides have been retrieved, update RecyclerView
        getAllRidesTask.getTask().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //once everything is received, create the adapter
                CreateAdapter(finishedList);
            }
        });


    }

    //depending on what option is selected in spinner, apply various filters to the list of available vehicles
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        System.out.println("Selected: " + selected);

        if(selected.equals("No Filter")){
            recreate("No Filter");
        }
        else if(selected.equals("Car")){
            recreate("car");
        }
        else if(selected.equals("Helicopter")){
            recreate("helicopter");
        }
        else if(selected.equals("Bike")){
            recreate("bike");
        }
        else if(selected.equals("Segway")){
            recreate("segway");
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    //create the adapter for the RecyclerView again with new filtered list
    public void recreate(String type){
        if(type.equals("No Filter")){
            CreateAdapter(finishedList);
        }

        else{
            ArrayList<Vehicle> temp = new ArrayList<>();

            type = type.toLowerCase();
            for(Vehicle v : finishedList){
                if(v.getVehicleType().equals(type)){
                    temp.add(v);
                }
            }
            CreateAdapter(temp);
        }




    }

    //go to vehicle info activity when a vehicle is clicked and bundle id info with it
    @Override
    public void onNoteClick(int position) {
        System.out.println("CLICKED: " + position);

        Intent intent = new Intent(this, specific_vehicle_info.class);

//        intent.putExtra("pos",  position);
        intent.putExtra("id", "" + finishedList.get(position).getVehicleID());

        startActivity(intent);
    }
}