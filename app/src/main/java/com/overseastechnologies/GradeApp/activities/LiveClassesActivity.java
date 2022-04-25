package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.overseastechnologies.GradeApp.MainActivity;
import com.overseastechnologies.GradeApp.ui.Liveclasses.SectionsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import GradeApp.R;
import GradeApp.databinding.ActivityLiveclassesBinding;

public class LiveClassesActivity extends MainActivity {

    RecyclerView recyclerView;
//    List<Liveclass> liveListClass;
    private static  String URL = "";

//    LiveClassAdapter liveClassAdapter;




    ActivityLiveclassesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveclassesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(LiveClassesActivity.this, getSupportFragmentManager());

        recyclerView=findViewById(R.id.liveClassList);
//        liveListClass= new ArrayList<>();


//        extractLiveClass();












        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager,true);

        binding.ivBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }

//    private void extractLiveClass() {
//
//        RequestQueue queue= Volley.newRequestQueue(this);
//
//        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, URL, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject liveObject = response.getJSONObject(i);
//
//                        Liveclass liveclass = new Liveclass();
//                        liveclass.setSubjectName(liveObject.getString("subjectName").toString());
//                        liveclass.setClassUrl(liveObject.getString("URL").toString());
//
//                        liveListClass.add(liveclass);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                liveClassAdapter=new LiveClassAdapter(getApplicationContext() ,liveListClass);
//                recyclerView.setAdapter(liveClassAdapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("tag","onErrorResponse"+error.getMessage());
//
//            }
//        });
//
//
//        queue.add(jsonArrayRequest);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
