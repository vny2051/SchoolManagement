package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;

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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
