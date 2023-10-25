package com.example.hams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hams.databinding.RejectedRequestsPageBinding;

import java.util.ArrayList;

public class rejectedRequests extends AppCompatActivity {

    RejectedRequestsPageBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList2 = new ArrayList<>();
    ListData listData2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RejectedRequestsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] emailList = {"email1", "email2"}; //stores the emails of everyone pending
        String[] typeList = {"Doctor", "Patient"}; //stores if the person is a doctor or patient

        for(int i = 0; i < emailList.length; i++) {
            listData2 = new ListData(emailList[i], typeList[i]);
            dataArrayList2.add(listData2);
        }

        listAdapter = new ListAdapter(rejectedRequests.this, dataArrayList2);
        binding.listview2.setAdapter(listAdapter);
        binding.listview2.setClickable(true);

        binding.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(rejectedRequests.this, detailedRejectedRequest.class);
                intent.putExtra("email", emailList[i]);
                intent.putExtra("type", typeList[i]);
                startActivity(intent);
            }
        });




    }

}

