package com.example.hams;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hams.databinding.DetailedViewPendingRequestsBinding;


public class detailedPendingRequest extends AppCompatActivity {

    DetailedViewPendingRequestsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailedViewPendingRequestsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {
            String email = intent.getStringExtra("email");
            String type = intent.getStringExtra("type");

            binding.detailEmail.setText(email);
            binding.detailType.setText(type);

        }
    }
}
