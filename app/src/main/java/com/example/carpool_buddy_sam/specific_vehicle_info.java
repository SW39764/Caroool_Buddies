package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

public class specific_vehicle_info extends AppCompatActivity {

    TextView infoField;

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        setContentView(R.layout.activity_specific_vehicle_info);

        infoField = findViewById(R.id.vehicleInfo);

        Bundle extras = getIntent().getExtras();

        if(getIntent().hasExtra("id")){
            String id = extras.getString("id");
            System.out.println(id);
            DocumentReference doc = firestore.collection(com.example.carpool_buddy_sam.Constants.VEHICLE_COLLECTION).document("vehicle" + id);


            doc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.get("vehicleType").equals("car")){
                        Car vehicle = documentSnapshot.toObject(Car.class);

                    }
                    else if(documentSnapshot.get("vehicleType").equals("bike")){
                        Bycicle vehicle = documentSnapshot.toObject(Bycicle.class);

                    }
                    else if(documentSnapshot.get("vehicleType").equals("Helicopter")){
                        HeliCopter vehicle = documentSnapshot.toObject(HeliCopter.class);

                    }
                    else if(documentSnapshot.get("vehicleType").equals("Segway")){
                        Segway vehicle = documentSnapshot.toObject(Segway.class);

                    }

                }
            });

        }
    }
}