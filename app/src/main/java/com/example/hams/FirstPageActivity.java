package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirstPageActivity extends AppCompatActivity {
    //These are when we are given the choice are you a patient or a doctor
    private Button theLoginButton;
    private Button theRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the UI elements
        theLoginButton = findViewById(R.id.login_button);
        theRegisterButton = findViewById(R.id.register_button);

        // Set button click listeners
        theLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get login email and password
                EditText emailEntry = findViewById(R.id.username_text);
                EditText passwordEntry = findViewById(R.id.password_text);
                String email = emailEntry.getText().toString();
                String password = passwordEntry.getText().toString();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                //Search DB for patients with matching email
                Query patientsQuery = reference.child("Patients").orderByChild("emailAddress").equalTo(emailEntry.getText().toString());
                patientsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot patient : dataSnapshot.getChildren()) {
                                //If password matches, continue to welcome page
                                if (password.equals(patient.child("password").getValue(String.class))){
                                    Intent intent = new Intent(FirstPageActivity.this, LogOutPatient.class);
                                    startActivity(intent);
                                } else {
                                    emailEntry.setError("Login failed. Please double check the email and password.");
                                }
                            }
                        } else {
                            emailEntry.setError("Login failed. Please double check the email and password.");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //Search DB for doctors with matching email
                Query doctorsQuery = reference.child("Doctors").orderByChild("emailAddress").equalTo(emailEntry.getText().toString());
                doctorsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot patient : dataSnapshot.getChildren()) {
                                //If password matches, continue to welcome page
                                if (password.equals(patient.child("password").getValue(String.class))){
                                    Intent intent = new Intent(FirstPageActivity.this, LogOutDoctor.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //Search DB for administrators with matching email
                Query adminQuery = reference.child("Administrators").orderByChild("emailAddress").equalTo(emailEntry.getText().toString());
                adminQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot patient : dataSnapshot.getChildren()) {
                                //If password matches, continue to welcome page
                                if (password.equals(patient.child("password").getValue(String.class))){
                                    Intent intent = new Intent(FirstPageActivity.this, LogOutAdministrator.class);
                                    startActivity(intent);
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        theRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstPageActivity.this, DoctororPatientActivity.class);
                startActivity(intent);
            }
        });
    }
}