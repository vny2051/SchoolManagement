package com.overseastechnologies.GradeApp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import GradeApp.databinding.ActivityLoginSelectionBinding;

public class LoginSelectionActivity extends AppCompatActivity {

    ActivityLoginSelectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =   ActivityLoginSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLoginMethod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginSelectionActivity.this, LoginActivityPass.class) );
            }
        });
        binding.btnLoginMethod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginSelectionActivity.this, LoginActivityOtp.class) );
            }
        });
    }
}