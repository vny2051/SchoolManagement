package com.overseastechnologies.GradeApp.activities;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.overseastechnologies.GradeApp.apiController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.overseastechnologies.GradeApp.DBHelper;
import com.overseastechnologies.GradeApp.MainActivity;
import com.overseastechnologies.GradeApp.responseModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import GradeApp.databinding.ActivityLoginPassBinding;
import retrofit2.Call;
import retrofit2.Callback;

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
                JSONObject jsonBody = new JSONObject();
                final String requestBody;


                String username = binding.etUserEmailId.getText().toString();
                String password = binding.etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivityPass.this, "empty", Toast.LENGTH_SHORT).show();
                } else {


                    try {
                        jsonBody.put("emailID", "jagrutipatel@gmail.com");
                        jsonBody.put("password", "123");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    requestBody = jsonBody.toString();
                    /** string request **/
                    //                    StringRequest stringRequest = new StringRequest(Request.Method.POST, apiUrl, new Response.Listener<String>() {
                    //                        @Override
                    //                        public void onResponse(String response) {
                    //                            if (response.equals("user exist")) {
                    //                                Toast.makeText(LoginActivityPass.this, "Login Successful" + response, Toast.LENGTH_SHORT).show();
                    //                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    //                            } else {
                    //                                Toast.makeText(LoginActivityPass.this, response, Toast.LENGTH_SHORT).show();
                    //                            }
                    //                        }
                    //                    }, new Response.ErrorListener() {
                    //                        @Override
                    //                        public void onErrorResponse(VolleyError error) {
                    //                            Toast.makeText(LoginActivityPass.this, "error................" + error.toString(), Toast.LENGTH_SHORT).show();
                    //                            Log.e("vny", error.toString());
                    //                        }
                    //                    }) {
                    //                        @Nullable
                    //                        @Override
                    //                        public Map<String, String> getParams() throws AuthFailureError {
                    //                            Map<String, String> map = new HashMap<String, String>();
                    //                            map.put("email", username);
                    //                            map.put("password", password);
                    //                            return map;
                    //                        }
                    //
                    //                        @Override
                    //                        public Map<String, String> getHeaders() throws AuthFailureError {
                    //                            HashMap header = new HashMap();
                    //                            header.put("Content-Type", "application/json");
                    //                            header.put("Developerkey", "schlMana20Ge22");
                    //
                    //                            return header;
                    //                        }
                    //
                    //                        @Override
                    //                        public byte[] getBody() throws AuthFailureError {
                    //                            JSONObject jsonObject = new JSONObject();
                    //                            String body = null;
                    //                            try {
                    //                                jsonObject.put("emailID", "jagrutipatel@gmail.com");
                    //                                jsonObject.put("password", "123");
                    //
                    //                                body = jsonObject.toString();
                    //                            } catch (JSONException e) {
                    //                                // TODO Auto-generated catch block
                    //                                e.printStackTrace();
                    //                                Toast.makeText(LoginActivityPass.this, "naithyu1", Toast.LENGTH_SHORT).show();
                    //                            }
                    //
                    //                            try {
                    //                                return body.getBytes("utf-8");
                    //                            } catch (UnsupportedEncodingException e) {
                    //                                // TODO Auto-generated catch block
                    //                                e.printStackTrace();
                    //                                Toast.makeText(LoginActivityPass.this, "naithyu2", Toast.LENGTH_SHORT).show();
                    //                            }
                    //                            return null;
                    //                        }
                    //
                    //                        @Override
                    //                        public String getBodyContentType() {
                    //                            return "application/json";
                    //                        }
                    //                    };

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                            (Request.Method.POST, apiUrl, null, new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(LoginActivityPass.this, "success", Toast.LENGTH_SHORT).show();
                                }
                            }, new Response.ErrorListener() {

                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(LoginActivityPass.this, "failure" + error.toString(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {

                            HashMap header = new HashMap();
                            header.put("Content-Type", "application/json");
                            header.put("Developerkey", "schlMana20Ge22");

                            return header;
                        }

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }

                        @Override
                        public byte[] getBody() {

                            return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
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