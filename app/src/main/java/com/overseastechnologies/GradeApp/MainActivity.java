package com.overseastechnologies.GradeApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;
import com.overseastechnologies.GradeApp.activities.AboutActivity;
import com.overseastechnologies.GradeApp.activities.AssignmentsActivity;
import com.overseastechnologies.GradeApp.activities.ContactActivity;
import com.overseastechnologies.GradeApp.activities.DashboardActivity;
import com.overseastechnologies.GradeApp.activities.DigitalLibraryActivity;
import com.overseastechnologies.GradeApp.activities.FeeStatusActivity;
import com.overseastechnologies.GradeApp.activities.FeedbackActivity;
import com.overseastechnologies.GradeApp.activities.LiveClassesActivity;
import com.overseastechnologies.GradeApp.activities.ProfileActivity;
import com.overseastechnologies.GradeApp.activities.StatisticsActivity;
import com.overseastechnologies.GradeApp.activities.StudyMaterialActivity;

import GradeApp.R;
import GradeApp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //for navigation drawer
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.nav_app_bar_open_drawer_description, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerSlideAnimationEnabled(true);
        toggle.syncState();

        //landscape krie to data pachu load ni
        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new HomeFragment()).commit();

        }

        //navigation drawer click listeners
        binding.navigationMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

                switch (menuitem.getItemId()) {
                    case R.id.home_menu:
                        Toast.makeText(MainActivity.this, "You're already in Home", Toast.LENGTH_SHORT).show();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.about_menu:
                        startActivity(new Intent(MainActivity.this, AboutActivity.class));
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.feestatus_menu:
                        startActivity(new Intent(MainActivity.this, FeeStatusActivity.class));
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.profile_menu:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        Toast.makeText(getApplicationContext(), "Profile pannel is open", Toast.LENGTH_LONG).show();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.contact_menu:
                        startActivity(new Intent(MainActivity.this, ContactActivity.class));
                        Toast.makeText(getApplicationContext(), "Contact pannel is open", Toast.LENGTH_LONG).show();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.feedback_menu:
                        startActivity(new Intent(MainActivity.this, FeedbackActivity.class));
                        Toast.makeText(getApplicationContext(), "Feedback pannel is open", Toast.LENGTH_LONG).show();
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }

                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        //click listeners
        binding.cvDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                finish();
            }
        });
        binding.cvStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
                finish();
            }
        });
        binding.cvLiveClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LiveClassesActivity.class));
                finish();
            }
        });
        binding.cvAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssignmentsActivity.class));
                finish();
            }
        });
        binding.cvDigitalLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DigitalLibraryActivity.class));
                finish();
            }
        });
        binding.cvStudyMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StudyMaterialActivity.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {

        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
