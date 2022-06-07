package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Class for activity of homescreen, allows users to navigate to other activities
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * onClick method - when a user clicks the sign in button, it will go to the sign in activity
     * @param v View for button
     */
    //sends user to next activity
    public void goToUsers(View v){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
}