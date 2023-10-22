package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.LinkedList;

public class DoctorRegistrationTransitionPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This will redirect to the doctorregistration xml UI
        setContentView(R.layout.doctor_account_form);

        // Initialize UI elements (EditText, Button, etc.)
        //we initialized the button for which what will happen when we click on the confirmation button
        Button registerButton = findViewById(R.id.doctor_confirm_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
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


                //now we will temporarily sstore the info of the Doctor in the following
                //EditText are written. they correspond to the edittexts
                //entered by the patient

                EditText lastNameEntry = findViewById(R.id.doctor_lastname_entry);
                EditText firstNameEntry = findViewById(R.id.doctor_firstname_entry);
                EditText emailEntry = findViewById(R.id.doctor_email_entry);
                EditText phoneNumberEntry = findViewById(R.id.doctor_phone_entry);
                EditText addressEntry = findViewById(R.id.doctor_address_entry);
                EditText employeeNumberEntry = findViewById(R.id.doctor_employee_num_entry);
                EditText passwordEntry = findViewById(R.id.doctor_password_entry);
                EditText specialtiesEntry= findViewById(R.id.doctor_specialties_entry) ;



                if (pressID == R.id.doctor_confirm_button) {

                    //Now we will call the java class static method to make sure no errorrs
                    //were made by the patient at entry point
                    boolean isFirstNameValid = InputValidation.nameValidity(firstNameEntry);
                    boolean isLastNameValid = InputValidation.lastNameValidity(lastNameEntry);
                    boolean isEmailValid = InputValidation.emailValidity(emailEntry);
                    boolean isPhoneNumberValid = InputValidation.phoneNumberValidity(phoneNumberEntry);
                    boolean isAddressValid = InputValidation.addressValidity(addressEntry);
                    boolean isEmployeeNumberValid = InputValidation.employeeNumberValidity(employeeNumberEntry);
                    boolean isPasswordValid = InputValidation.passwordValidity(passwordEntry);
                    boolean isSpecializationsValid = InputValidation.specialtiesValidity(specialtiesEntry);

                    //we will convert all of the EditText to String
                    String firstName = firstNameEntry.getText().toString();
                    String lastName = lastNameEntry.getText().toString();
                    String email = emailEntry.getText().toString();
                    String phoneNumber = phoneNumberEntry.getText().toString();
                    String address = addressEntry.getText().toString();
                    String employeeNumber = employeeNumberEntry.getText().toString();
                    String password = passwordEntry.getText().toString();

                    // Split specialties by comma and add to a LinkedList
                    String specialtiesText = specialtiesEntry.getText().toString();
                    String[] specialtiesArray = specialtiesText.split(", ");
                    LinkedList<String> specializations = new LinkedList<>(Arrays.asList(specialtiesArray));


                    if (isFirstNameValid && isLastNameValid && isEmailValid && isPhoneNumberValid && isAddressValid && isEmployeeNumberValid && isPasswordValid) {
                        //if everything is good we will just create a new Doctor
                        //we will pass as parameters the parameters of the constructor patient
                        //this newPatient will now then be stored in the database
                        Doctor newDoctor = new Doctor(firstName, lastName, email, password, phoneNumber, address, employeeNumber, specializations);

                        //Add doctor to DB
                        DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();
                        dbReference.child("Doctors").child(newDoctor.getEmployeeNumber()).setValue(newDoctor);
                        //Go back to login page
                        Intent intent = new Intent(DoctorRegistrationTransitionPage.this, FirstPageActivity.class);
                        startActivity(intent);
                    }
                }
            }

        });
    }
}
