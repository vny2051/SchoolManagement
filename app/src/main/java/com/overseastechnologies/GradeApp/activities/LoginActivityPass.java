package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import GradeApp.databinding.ActivityLoginPassBinding;

public class LoginActivityPass extends AppCompatActivity {

    ActivityLoginPassBinding binding;
    String apiUrl = "http://schoolmanagement.jihsuyaainfotech.in/api/student/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.etUserEmailId.getText().toString();
                String password = binding.etPassword.getText().toString();


                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivityPass.this, "empty", Toast.LENGTH_SHORT).show();
                } else {

//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, apiUrl, new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//
//                            Toast.makeText(LoginActivityPass.this, response, Toast.LENGTH_SHORT).show();
//
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(LoginActivityPass.this, "part of success...." + error.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    }) {
//                        @Override
//                        public Map<String, String> getHeaders() throws AuthFailureError {
//                            Map<String, String> header = new HashMap<String, String>();
//                            header.put("Developerkey", " schlMana20Ge22");
//
//                            return header;
//                        }
//
//                        //                        @Nullable
////                        @Override
////                        public Map<String, String> getParams() throws AuthFailureError {
////                            Map<String,String> header = new HashMap<String,String>();
////                            header.put("emailID","jagrutipatel@gmail.com");
////                            header.put("password","123");
////
////                            return header;
////                        }
////
////                        @Nullable
////                        @Override
////                        protected Map<String, String> getPostParams() throws AuthFailureError {
////                            Map<String,String> header = new HashMap<String,String>();
////                            header.put("emailID","jagrutipatel@gmail.com");
////                            header.put("password","123");
////
////                            return header;
////                        }
//                        @Override
//                        public byte[] getBody() {
//                            String str = "{\"emailID\":\"" + email + "\",\"password\":\"" + password + "\"}";
//                            return str.getBytes();
//                        }
//
//                    };

                    //jsonObject Request
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, apiUrl, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {


                                if (response.getString("status").equals("true")) {

                                    JSONObject data = response.getJSONObject("data");





                                    String studentId = data.getString("studentID");
                                    String firstName = data.getString("firstName");
                                    String lastName = data.getString("lastName");


                                    Toast.makeText(LoginActivityPass.this, "poyra ni id : " + studentId + "\n poyra nu first-name : " + firstName + "\n poyra nu last name : " + lastName + "\n\n NAVA Poyra Avla se....", Toast.LENGTH_SHORT).show();

                                    Intent intent= new Intent(LoginActivityPass.this, ProfileActivity.class);
                                    intent.putExtra("studentID",studentId);
                                    intent.putExtra("firstName",firstName);
                                    intent.putExtra("lastName",lastName);
                                    startActivity(intent);
                                    finish();
//
//                                    startActivity(new Intent(LoginActivityPass.this, MainActivity.class));

                                }
                                else {


                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivityPass.this, "part of success...." + error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> header = new HashMap<String, String>();
                            header.put("Developerkey", " schlMana20Ge22");

                            return header;
                        }

                        @Override
                        public byte[] getBody() {

                            //another way of sending body raw data...
//                            String str = "{\"emailID\":\"" + email + "\",\"password\":\"" + password + "\"}";
//                            return str.getBytes();

                            JSONObject bodyParameters = new JSONObject();
                            try {
                                bodyParameters.put("emailID", email);
                                bodyParameters.put("password", password);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            return bodyParameters.toString().getBytes();

                        }
                    };


                    RequestQueue queue = Volley.newRequestQueue(LoginActivityPass.this);
                    queue.add(jsonObjectRequest);


                }
            }
        });


    }

//    public void processData() {
//        Call<List<responseModel>> call = apiController
//                .getInstance()
//                .getapi()
//                .getdata();
//
//        call.enqueue(new Callback<List<responseModel>>() {
//            @Override
//            public void onResponse(Call<List<responseModel>> call, Response<List<responseModel>> response) {
//                List<responseModel> dataList = response.body();
//                Toast.makeText(LoginActivityPass.this, response.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<responseModel>> call, Throwable t) {
//                Toast.makeText(LoginActivityPass.this, "Error... : " + t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}