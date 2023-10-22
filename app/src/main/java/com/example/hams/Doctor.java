package com.example.hams;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

import java.util.LinkedList;

public class Doctor extends User {
    //Used for ID in DB
    //Instance Variables
    private String firstName;
    private String lastName;
    private String emailAddress ;
    private String password;
    private String phoneNumber;
    private String address;
    private String employeeNumber;
    //since we can have multiple specialties
    //we will use a linked list to store the specialties
    private LinkedList<String> specializations;

    private String registrationStatus;


    //CONSTRUCTOR OF DOCTOR
    public Doctor(String firstName, String lastName, String emailAddress, String password, String phoneNumber, String address, String employeeNumber , LinkedList<String> specializations){
        this.firstName= firstName;
        this.lastName= lastName;
        this.emailAddress= emailAddress;
        this.password = password;
        this.phoneNumber= phoneNumber;
        this.address= address;
        this.employeeNumber= employeeNumber;
        this.specializations = specializations;
        this.registrationStatus = "pending";
    }

    //Empty constructor needed for Firebase
    public Doctor() {

    }

    //Getters
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmailAddress(){return emailAddress;}
    public String getPassword(){return password;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getAddress(){return address;}
    public String getEmployeeNumber(){return employeeNumber;}
    public LinkedList<String> getSpecializations(){return specializations;}
    public String getRegistrationStatus(){return registrationStatus;}

}
