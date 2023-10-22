package com.example.hams;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class Patient extends User {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String address;
    private String healthCardNumber;

    private String registrationStatus;

    //CONSTRUCTOR
    public Patient(String firstName , String lastName, String emailAddress, String password, String phoneNumber, String address, String healthCardNumber){

        this.firstName= firstName;
        this.lastName = lastName;
        this.emailAddress= emailAddress;
        this.password=password;
        this.phoneNumber= phoneNumber;
        this.address=address;
        this.healthCardNumber= healthCardNumber;
        this.registrationStatus = "pending";
    }

    //Empty constructor needed for Firebase
    public Patient(){

    }

    //Getters
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmailAddress(){return emailAddress;}
    public String getPassword(){return password;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getAddress(){return address;}
    public String getHealthCardNumber(){return healthCardNumber;}
    public String getRegistrationStatus(){return registrationStatus;}

}
