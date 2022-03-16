package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;


import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.overseastechnologies.GradeApp.ui.Liveclasses.SectionsPagerAdapter;

import GradeApp.databinding.ActivityLiveclassesBinding;

public class LiveClassesActivity extends MainActivity{

    ActivityLiveclassesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveclassesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(LiveClassesActivity.this, getSupportFragmentManager());

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager,true);

        binding.ivBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
