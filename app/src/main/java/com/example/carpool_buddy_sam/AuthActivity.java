package com.example.carpool_buddy_sam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * Class for verification activity - used to verify user's email address
 * @author Sam
 * @version 1.0
 */
//activity that allows people to either sign in or go to activity where new account can be created
public class AuthActivity extends AppCompatActivity {

    //instance variables
    static public FirebaseAuth mAuth;
    static public FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;


    /**
     * onCreate method - sets up the activity, establishes connection to firebase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);

        //establish connection to firebase
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //initialize fields
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
    }

    /**
     * onClick method - when a user clicks sign in button, it will attempt to sign in the user
     * if it does not work it will provide an error message, if it does work it will go to the main activity
     *
     * @param v View
     */
    public void signIn(View v){
        //get email and password from fields
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();


        mAuth = FirebaseAuth.getInstance();

        //sign in user
        mAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    //once completed, check if sign in was successful
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //if it was successful, go to main activity
                            Log.d("SIGNIN SUCESSFULL", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUi(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SIGNIN SUCESSFULL", "signInWithEmail:failure", task.getException());
                            updateUi(null);
                        }
                    }
                });

    }


    /**
     * onClick method - checks if user is signed in, if so, it will move to the main activity, otherwise it will not do anything
     *
     * @param currUser FirebaseUser to check if user is signed in
     */
    //logs user in if sign in was successful and sends user to main activity
    public void updateUi(FirebaseUser currUser){
        if (currUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    /**
     * onClick method - when a user clicks sign up button, moves user to sign up activity
     *
     * @param v View
     */
    //sends user to sign up activity on button press
    public void otherLogin(View v){
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }


}