package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carpool_buddy_sam.Users.Alumni;
//import com.example.carpoolbuddy.Models.Alumni;
//import com.example.carpoolbuddy.Models.User;
//import com.example.carpoolbuddy.R;
import com.example.carpool_buddy_sam.Users.Parent;
import com.example.carpool_buddy_sam.Users.Student;
import com.example.carpool_buddy_sam.Users.Teacher;
import com.example.carpool_buddy_sam.Vehicles.Vehicle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/**
 * Class for user to create activity, works with create user activity
 * User can pick between different types of users
 */
//Activity that creates new account for user and stores it in the database
public class CreateUserActivity extends AppCompatActivity {
    //instance variables
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private LinearLayout layout;
    private EditText emailField;
    private EditText passwordField;
    private EditText nameField;
    private EditText gradYearField;
    private EditText parentUIDField;
    private EditText inSchoolTitleField;
    private EditText childrenTextField;

    private Spinner userRoleSpinner;
    private String selectedRole;


    /**
     * onCreate method - sets up the activity, adds spinner and layout as well as setting up connection to firebase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //establish connection to firebase
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.linearLayoutCreateUser);
        userRoleSpinner = findViewById(R.id.selectTypeSpinner);

        //creates spinner for user types
        setupSpinner();

    }

    /**
     * Method to setup spinner for user types
     */
    // setup spinner where user selects what user type they want to make an account for
    private void setupSpinner() {
        String[] userTypes = {"Student", "Teacher", "Alumni", "Parent"};
        // add user types to spinner
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(CreateUserActivity.this,
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

    /**
     * Method to add fields to the layout
     */
    public void addFields() {
        //adds common fields that all user types inherit from parent class User
        commonFields();

        //adds fields depending on what user type is selected in spinner
        if(selectedRole.equals("Alumni")) {
            gradYearField = new EditText(this);
            gradYearField.setHint("Graduation year");
            layout.addView(gradYearField);
        }
        if(selectedRole.equals("Student")) {
            gradYearField = new EditText(this);
            parentUIDField = new EditText(this);

            gradYearField.setHint("Graduation year");
            parentUIDField.setHint("Parent UID");

            layout.addView(gradYearField);
            layout.addView(parentUIDField);

        }
        if(selectedRole.equals("Parent")) {
            childrenTextField = new EditText(this);

            childrenTextField.setHint("Children");

            layout.addView(inSchoolTitleField);
        }
        if(selectedRole.equals("Teacher")) {
            inSchoolTitleField = new EditText(this);
            inSchoolTitleField.setHint("In-school title");
            layout.addView(inSchoolTitleField);
        }
    }

    /**
     * Method to add common fields to the layout
     * fields that all user types inherit from parent class User
     */
    public void commonFields() {
        //add common fields from User parent class
        layout.removeAllViewsInLayout();
        nameField = new EditText(this);
        nameField.setHint("Name");
        layout.addView(nameField);
        emailField = new EditText(this);
        emailField.setHint("Email");
        layout.addView(emailField);
        passwordField = new EditText(this);
        passwordField.setHint("Password");
        layout.addView(passwordField);
    }

    /**
     * OnClick Method - to create new user
     * calls updateUI method to check if it was succesfull and move user to next activity
     * @param v View
     */
    //creates user account and sends to database
    public void signUp(View v) {
        //gets user input
        String nameString = nameField.getText().toString();
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();

        //creates a login account
        mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.d("SIGN UP", "successfully signed up the user");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else {
                            Log.d("SIGN UP", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(CreateUserActivity.this,"Sign up failed", Toast.LENGTH_LONG).show();
                            updateUI(null);
                        }
                    }
                });

        //creates document in database and gets id
        DocumentReference newUserRef = firestore.collection(Constants.USER_COLLECTION).document();
        String userID = newUserRef.getId();

        //creates user depending on what user type is selected
        if(selectedRole.equals("Alumni")) {
            int gradYearInt = Integer.parseInt(gradYearField.getText().toString());
            Alumni newUser = new Alumni(userID, nameString, emailString, gradYearInt);
//            firestore.collection("people").document(userID).set(newUser);
            newUserRef.set(newUser);
        }
        else if(selectedRole.equals("Student")) {
            String gradYear = gradYearField.getText().toString();
            Student newUser = new Student(userID, nameString, emailString, gradYear);
            newUserRef.set(newUser);

        }
        else if(selectedRole.equals("Parent")) {
            Parent newUser = new Parent(userID, nameString, emailString);
            newUserRef.set(newUser);
        }
        else if(selectedRole.equals("Teacher")) {
            String inSchoolName = inSchoolTitleField.getText().toString();
            Teacher newUser = new Teacher(userID, nameString, emailString, inSchoolName);
            newUserRef.set(newUser);
        }

        //sends new account to database and sends user to UserProfile activity
        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }

    /**
     * Method to update UI
     * if user is logged in it will move the user to the next activity
     * @param currentUser FirebaseUser to check if user is logged in
     */
    //if signup was successful, sends user to UserProfile activity
    public void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Intent intent = new Intent(this, UserProfile.class);
            startActivity(intent);
        }
    }
}