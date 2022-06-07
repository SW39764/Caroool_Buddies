package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Class for activity of homescreen, allows users to navigate to other activities
 */
public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }

    /**
     * onClick method - when a user clicks the button, it will go to the vehicle info activity
     * @param v View for button
     */
    //go to vehicleinfo activity
    public void goToVehicle(View v){
        Intent intent = new Intent(this, VehicleInfo.class);
        startActivity(intent);
    }
}