package com.example.carpool_buddy_sam;

import static com.example.carpool_buddy_sam.vehiclesRecycler.finishedList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.example.carpool_buddy_sam.Vehicles.Bycicle;
import com.example.carpool_buddy_sam.Vehicles.Car;
import com.example.carpool_buddy_sam.Vehicles.HeliCopter;
import com.example.carpool_buddy_sam.Vehicles.Segway;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;

public class specific_vehicle_info extends AppCompatActivity {

    TextView infoField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_vehicle_info);

        infoField = findViewById(R.id.vehicleInfo);

        Bundle extras = getIntent().getExtras();

        if(getIntent().hasExtra("pos") && getIntent().hasExtra("type")){
            int position = extras.getInt("pos");
            String type = extras.getString("type");

            if(type.equals("car")){
                Car vehicle = (Car) finishedList.get(position);
                infoField.setText(vehicle.toString());
            }

            else if(type.equals("bycicle")){
                Bycicle vehicle = (Bycicle) finishedList.get(position);
                infoField.setText(vehicle.toString());
            }
            else if(type.equals("HeliCopter")){
                HeliCopter vehicle = (HeliCopter) finishedList.get(position);
                infoField.setText(vehicle.toString());

            }
            else if(type.equals("Segway")){
                Segway vehicle = (Segway) finishedList.get(position);
                infoField.setText(vehicle.toString());

            }




        }
    }
}