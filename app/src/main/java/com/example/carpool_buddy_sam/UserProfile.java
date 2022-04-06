package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }

    public void goToVehicle(View v){
        Intent intent = new Intent(this, VehicleInfo.class);
        startActivity(intent);
    }
}