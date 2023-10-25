package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class rejectedRequestsButton extends AppCompatActivity {
    private Button rejectedReqButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_welcome_page);

        rejectedReqButton = findViewById(R.id.rejected_requests_button);


        rejectedReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(rejectedRequestsButton.this, rejectedRequests.class);
                startActivity(intent);
            }
        });


    }
}