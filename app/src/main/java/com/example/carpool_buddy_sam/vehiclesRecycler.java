package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class vehiclesRecycler extends AppCompatActivity {

    RecyclerView recView;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private ArrayList<Vehicle> vehiclesList;

    private ArrayList<String> ownerList;
    private ArrayList<String> typeList;
    private ArrayList<Integer> capacityList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles_recycler);

        vehiclesList = new ArrayList<Vehicle>();
        ownerList = new ArrayList<String>();
        typeList = new ArrayList<String>();
        capacityList = new ArrayList<Integer>();

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        recView = findViewById(R.id.recView);


        getVehicles();


//        ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
//        Vehicle vehicle = new Segway("String owner", "String model", 12, "String vehicleID",
//                null, true, "String vehicleType",
//        12.2, 12, 321);
//        vehiclesList.add(vehicle);


//        ArrayList<Vehicle> allVehicles = getVehicles();

//        System.out.println("allVehicles: " + vehiclesList);


//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("VehiclesList: " + allVehicles);


//        System.out.println("Just before creating adapter");


    }

    public void CreateAdapter(ArrayList<Vehicle> vehicles){

        vehiclesRecViewAdapter myAdapter = new vehiclesRecViewAdapter(ownerList, typeList, capacityList);

        recView.setAdapter(myAdapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getVehicles(){
        vehiclesList.clear();
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

                            ownerList.add(temp.getOwner());
                            typeList.add(temp.getVehicleType());
                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("car")){
                            System.out.println("Added : " + document.toObject(Car.class));

                            Vehicle temp = (Vehicle) (document.toObject(Car.class));

                            ownerList.add(temp.getOwner());
                            typeList.add(temp.getVehicleType());
                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("helicopter")){
                            System.out.println("Added : " + document.toObject(HeliCopter.class));
                            Vehicle temp = (Vehicle) (document.toObject(HeliCopter.class));

                            ownerList.add(temp.getOwner());
                            typeList.add(temp.getVehicleType());
                            capacityList.add(temp.getCapacity());
                        }
                        if(type.equals("bycicle")){
                            System.out.println("Added : " + document.toObject(Bycicle.class));
                            Vehicle temp = (Vehicle) (document.toObject(Bycicle.class));

                            ownerList.add(temp.getOwner());
                            typeList.add(temp.getVehicleType());
                            capacityList.add(temp.getCapacity());
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
                System.out.println("VEHICLE INFO: " + vehiclesList.toString());

                CreateAdapter(vehiclesList);
            }
        });

//        System.out.println("RETURNING VEHICLES LIST RETURNING VEHICLES LIST RETURNING VEHICLES LIST RETURNING VEHICLES LIST RETURNING VEHICLES LIST RETURNING VEHICLES LIST");

    }

}