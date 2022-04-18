package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.overseastechnologies.GradeApp.MainActivity;

import GradeApp.R;
import GradeApp.databinding.ActivityProfileBinding;

public class ProfileActivity extends MainActivity {

    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(view -> onBackPressed());

        //student all details
        SharedPreferences sharedPreferences = getSharedPreferences("StudentInfo", MODE_PRIVATE);
        String sId = sharedPreferences.getString("studentId","");
        String sName = sharedPreferences.getString("fullName","");
        String mobNo = sharedPreferences.getString("mobileNo","");
        String email = sharedPreferences.getString("emailId","");

        String rollNo = sharedPreferences.getString("rollNo","");
        String registrationDate = sharedPreferences.getString("registrationDate","");
        String parentsEmail = sharedPreferences.getString("parentsEmail","");
        String parentsMobile = sharedPreferences.getString("parentsMobile","");
        String address = sharedPreferences.getString("address","");


        binding.NameProfile.setText(sName);
        binding.MobileProfile.setText(mobNo);
        binding.EmailProfile.setText(email);
        binding.IdProfile.setText(sId);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
