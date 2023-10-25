package com.example.hams;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class pendingRequestsButton extends AppCompatActivity {
    private Button pendingReqButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_welcome_page);

        pendingReqButton = findViewById(R.id.pending_requests_button);


        pendingReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(pendingRequestsButton.this, pendingRequests.class);
                startActivity(intent);
            }
        });


    }
}