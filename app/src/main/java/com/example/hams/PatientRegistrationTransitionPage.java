package com.example.hams;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PatientRegistrationTransitionPage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstance){
        //Android studio lingo
        super.onCreate(savedInstance);

        //This will redirect to the patientregistration XML UI that
        //asks the patient to put his personal information
        setContentView(R.layout.patient_account_form);

        //Initialize UI elements (EditText, Button, etc)
        //we initialized the button for which for which what will happen when we click on the
        //confirmationButton is what we use as variable now for the "CONFIRM"
        //confirmButtonPatientRegistration is the id of the 'CONFIRM" Button
        Button confirmationButton = findViewById(R.id.patient_confirm_button);

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle registration logic here
                // Validate input, send data to the server, etc.
                // Display success or error messages to the user
                //then insert it into the constructor of the Doctor
                //Lets begin!!

                //First we get the unique ID associated with our click
                //on android studio each click has an ID which is why we use this
                int pressID = view.getId();


                //now we will temporarily store the info of the patient in the following
                //EditText are written. they correspond to the edittexts
                //entered by the patient

                EditText lastNameEntry = findViewById(R.id.patient_lastname_entry);
                EditText firstNameEntry = findViewById(R.id.patient_firstname_entry);
                EditText emailEntry = findViewById(R.id.patient_email_entry);
                EditText phoneNumberEntry = findViewById(R.id.patient_phone_entry);
                EditText addressEntry = findViewById(R.id.patient_address_entry);
                EditText healthCardNumberEntry = findViewById(R.id.patient_employee_num_entry);
                EditText passwordEntry = findViewById(R.id.patient_password_entry);



                if (pressID == R.id.patient_confirm_button) {

                    //Now we will call the java class static method to make sure no errors
                    //were made by the patient at entry point
                    boolean isFirstNameValid = InputValidation.nameValidity(firstNameEntry);
                    boolean isLastNameValid = InputValidation.lastNameValidity(lastNameEntry);
                    boolean isEmailValid = InputValidation.emailValidity(emailEntry);
                    boolean isPhoneNumberValid = InputValidation.phoneNumberValidity(phoneNumberEntry);
                    boolean isAddressValid = InputValidation.addressValidity(addressEntry);
                    boolean isHealthCardNumberValid = InputValidation.healthCardNumberValidity(healthCardNumberEntry);
                    boolean isPasswordValid = InputValidation.passwordValidity(passwordEntry);

                    //we will convert all of the EditText to String
                    String firstName = firstNameEntry.getText().toString();
                    String lastName = lastNameEntry.getText().toString();
                    String email = emailEntry.getText().toString();
                    String phoneNumber = phoneNumberEntry.getText().toString();
                    String address = addressEntry.getText().toString();
                    String healthCardNumber = healthCardNumberEntry.getText().toString();
                    String password = passwordEntry.getText().toString();

                    if (isFirstNameValid && isLastNameValid && isEmailValid && isPhoneNumberValid && isAddressValid && isHealthCardNumberValid && isPasswordValid) {
                        //if everything is good we will just create a new Patient
                        //we will pass as parameters the parameters of the constructor patient
                        //this newPatient will now then be stored in the database
                        Patient newPatient = new Patient(firstName, lastName, email, password, phoneNumber, address, healthCardNumber);

                        //Add patient to the DB
                        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
                        dbReference.child("Patients").child(newPatient.getHealthCardNumber()).setValue(newPatient);

                        //Go back to login page
                        Intent intent = new Intent(PatientRegistrationTransitionPage.this, FirstPageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
