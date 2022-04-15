package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.tabs.TabLayout;
import com.overseastechnologies.GradeApp.MainActivity;
import com.overseastechnologies.GradeApp.ui.BooksList;
import com.overseastechnologies.GradeApp.ui.RecyclerViewAdapter;
import com.overseastechnologies.GradeApp.ui.Studymaterial.SectionsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import GradeApp.databinding.ActivityStudyMaterialBinding;

public class StudyMaterialActivity extends MainActivity {

    ActivityStudyMaterialBinding binding;

    private static String URl ="http://schoolmanagement.jihsuyaainfotech.in/api/student/studyMaterialsList";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<BooksList> listBooks;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudyMaterialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);


        listBooks=new ArrayList<>();
        recyclerView =findViewById(GradeApp.R.id.bookListRecycler);
        jsonrequest();




        //for back button
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void jsonrequest() {
        request= new JsonArrayRequest(URl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject  jsonObject=null;
                for (int i=0;i<response.length();i++){


                    try {
                        jsonObject =response.getJSONObject(i);
                        BooksList booksList= new BooksList();
                        booksList.setName(jsonObject.getString("name"));
                        booksList.setBook_url(jsonObject.getString("bookurl"));

                        listBooks.add(booksList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerview(listBooks);

            }

            private void setuprecyclerview(List<BooksList> listBooks) {
                RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,listBooks);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
