package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;

public class specific_vehicle_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_vehicle_info);

        if(getIntent().hasExtra("type")  && getIntent().hasExtra("vehicle")){
            ContactsContract.CommonDataKinds.Note type = getIntent().getParcelableExtra("type");
            ContactsContract.CommonDataKinds.Note vehicle = getIntent().getParcelableExtra("vehicle");

            System.out.println("type : " + type.toString());
            System.out.println("vehicle : " + vehicle.toString());
        }
    }
}