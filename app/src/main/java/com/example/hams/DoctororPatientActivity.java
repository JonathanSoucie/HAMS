package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctororPatientActivity extends Activity {
    //These are when we are given the choice are you a patient or a doctor
    private Button doctorButton;
    private Button patientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_selection); // here the xml is that
                                                        //of where we were asked a choice patient or doc
        // Initializing the UI elements
        doctorButton = findViewById(R.id.doctor_select_button);
        patientButton = findViewById(R.id.patient_select_button);

        // Set button click listeners
        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the choice to be a doctor
                // You can navigate to the doctor registration page class from here
                //the java class DoctorRegistrationTransition Page will make the second page of
                //the UI to pop up on which it will ask for the Doctor to add
                //his first name, last name, specialties etc..
                Intent intent = new Intent(DoctororPatientActivity.this, DoctorRegistrationTransitionPage.class);
                startActivity(intent);
            }
        });

        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the choice to be a patient
                // You can navigate to the patient-related page java class from here
                //the java class PatientRegistrationTransitionPage will make the UI change of page
                //Patient will put his necessary information namely name, health card number etc...
                Intent intent = new Intent(DoctororPatientActivity.this, PatientRegistrationTransitionPage.class);
                startActivity(intent);
            }
        });
    }
}
