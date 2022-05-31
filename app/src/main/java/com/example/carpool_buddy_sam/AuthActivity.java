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

//activity that allows people to either sign in or go to activity where new account can be created
public class AuthActivity extends AppCompatActivity {

    //instance variables
    static public FirebaseAuth mAuth;
    static public FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;


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

    //allows user to go to sign up activity by pressing a button
//    public void signUp(View v){
//        System.out.println("Sign Up");
//
//        String emailString = emailField.getText().toString();
//        String passwordString = passwordField.getText().toString();
//
//        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) {
//                    FirebaseUser user = mAuth.getCurrentUser();
//
//                    Log.d("SIGN UP ", "Sucessfully signed up");
//
//                    updateUi(user);
//                }
//                else{
//                    Log.w("SIGN UP", "createUserWithEmail:failure", task.getException());
////                    Toast.makeText(this, "Authentication failed.",
////                            Toast.LENGTH_SHORT).show();
//                    updateUi(null);
//                }
//            }
//        });
//    }

    //logs user in if sign in was successful and sends user to main activity
    public void updateUi(FirebaseUser currUser){
        if (currUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    //sends user to sign up activity on button press
    public void otherLogin(View v){
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }


}