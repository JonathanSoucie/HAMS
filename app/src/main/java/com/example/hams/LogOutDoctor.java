package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogOutDoctor extends AppCompatActivity {
    private Button logOutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_welcome_page);

        //we will just make the log out button match the one in the xml file
        logOutButton = findViewById(R.id.logout_button);


        // Set button click listeners
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(LogOutDoctor.this, FirstPageActivity.class);
                startActivity(intent);
            }
        });


    }
}