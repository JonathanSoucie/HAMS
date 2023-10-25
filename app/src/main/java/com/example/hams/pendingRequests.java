package com.example.hams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hams.databinding.PendingRequestsPageBinding;

import java.util.ArrayList;

public class pendingRequests extends AppCompatActivity {

    PendingRequestsPageBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PendingRequestsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] emailList = {"email1", "email2"}; //stores the emails of everyone pending
        String[] typeList = {"Doctor", "Patient"}; //stores if the person is a doctor or patient

        for(int i = 0; i < emailList.length; i++) { //this is what makes it show up in the list
            listData = new ListData(emailList[i], typeList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(pendingRequests.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(pendingRequests.this, detailedPendingRequest.class);
                intent.putExtra("email", emailList[i]); //this is what puts the email and type on the detailed page
                intent.putExtra("type", typeList[i]);
                startActivity(intent);
            }
        });




    }

}

