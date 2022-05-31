package com.example.carpool_buddy_sam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //sends user to next activity
    public void goToUsers(View v){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
}