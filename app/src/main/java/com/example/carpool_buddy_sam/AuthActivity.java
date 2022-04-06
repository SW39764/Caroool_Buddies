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

public class AuthActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
    }

    public void signIn(View v){
        System.out.println("Sign In:");

        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();

//        System.out.println("Email = " + emailString + ", password = " + passwordString);

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SIGNIN SUCESSFULL", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUi(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SIGNIN SUCESSFULL", "signInWithEmail:failure", task.getException());
//                            Toast.makeText(this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            updateUi(null);
                        }
                    }
                });

    }


    public void signUp(View v){
        System.out.println("Sign Up");

        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();

        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();

                    Log.d("SIGN UP ", "Sucessfully signed up");

                    updateUi(user);
                }
                else{
                    Log.w("SIGN UP", "createUserWithEmail:failure", task.getException());
//                    Toast.makeText(this, "Authentication failed.",
//                            Toast.LENGTH_SHORT).show();
                    updateUi(null);
                }
            }
        });
    }

    public void updateUi(FirebaseUser currUser){
        if (currUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

}