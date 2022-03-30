package com.overseastechnologies.GradeApp.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.overseastechnologies.GradeApp.DBHelper;
import com.overseastechnologies.GradeApp.MainActivity;

import java.util.HashMap;
import java.util.Map;

import GradeApp.databinding.ActivityLoginPassBinding;

public class LoginActivityPass extends AppCompatActivity {

    ActivityLoginPassBinding binding;
    DBHelper DB;
    String apiUrl = "http://192.168.0.114/api/loginApi.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB = new DBHelper(this);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = binding.etUserEmailId.getText().toString();
                String password = binding.etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivityPass.this, "empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, apiUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("user exist")) {
                                Toast.makeText(LoginActivityPass.this, "Login Successful"+response, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivityPass.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivityPass.this, "error................"+error.toString(), Toast.LENGTH_SHORT).show();
                            Log.e("vny",error.toString());
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("email", username);
                            map.put("password", password);
                            return map;
                        }
                    };

                    RequestQueue queue = Volley.newRequestQueue(LoginActivityPass.this);
                    queue.add(stringRequest);

                }
            }
        });
    }
}