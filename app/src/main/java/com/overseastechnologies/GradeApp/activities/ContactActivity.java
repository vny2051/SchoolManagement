package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.overseastechnologies.GradeApp.MainActivity;

import GradeApp.databinding.ActivityContactBinding;

public class ContactActivity extends MainActivity {

    ActivityContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
