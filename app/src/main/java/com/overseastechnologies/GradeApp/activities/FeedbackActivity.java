package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.overseastechnologies.GradeApp.MainActivity;

import GradeApp.R;
import GradeApp.databinding.ActivityFeedbackBinding;

public class FeedbackActivity extends MainActivity {

    ActivityFeedbackBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
