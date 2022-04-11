package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.overseastechnologies.GradeApp.MainActivity;

import GradeApp.R;
import GradeApp.databinding.ActivityProfileBinding;

public class ProfileActivity extends MainActivity {

    ActivityProfileBinding binding;
        EditText Name,Phone,Email,Password,Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ivBack.setOnClickListener(view -> onBackPressed());


        Name=findViewById(R.id.Name_profile);
        Phone=findViewById(R.id.Mobile_profile);
        Email=findViewById(R.id.Email_profile);
        Password=findViewById(R.id.Password_profile);
        Id=findViewById(R.id.Id_profile);


        Intent intent=getIntent();
        String pName= intent.getStringExtra("name");
        String pEmail=intent.getStringExtra("Email");
        String pFirst=intent.getStringExtra("firstName");
        String Pnumber= intent.getStringExtra("phoneNumber");
        String IdProfile= intent.getStringExtra("studentId");



        Name.setText(pFirst);
        Phone.setText("");
        Email.setText(pEmail);
        Id.setText(IdProfile);



    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
