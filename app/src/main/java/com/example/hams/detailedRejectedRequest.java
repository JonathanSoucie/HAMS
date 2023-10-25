package com.example.hams;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hams.databinding.DetailedViewRejectedRequestsBinding;


public class detailedRejectedRequest extends AppCompatActivity {

    DetailedViewRejectedRequestsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailedViewRejectedRequestsBinding.inflate(getLayoutInflater());
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
