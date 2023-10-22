package com.example.hams;

public class Administrator extends User {
    //Administrator is already pre-registered in the database
    private String firsName;
    private String lastName;
    private String emailAddress;
    private String password;


    public Administrator(String firsName, String lastName, String emailAddress, String password){
        this.firsName= firsName;
        this.lastName= lastName;
        this.emailAddress= emailAddress;
        this.password=password;

    }

}
