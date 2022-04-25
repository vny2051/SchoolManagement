package com.overseastechnologies.GradeApp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.overseastechnologies.GradeApp.MainActivity;
import com.overseastechnologies.GradeApp.ui.Studymaterial.SectionsPagerAdapter;

import GradeApp.databinding.ActivityStudyMaterialBinding;

public class StudyMaterialActivity extends MainActivity {

    ActivityStudyMaterialBinding binding;

//    private static String URl ="http://schoolmanagement.jihsuyaainfotech.in/api/student/studyMaterialsList";
//    JsonArrayRequest request;
//    RequestQueue requestQueue;
//    List<BooksList> listBooks;
//     RecyclerView recyclerView;
//    RecyclerViewAdapter recyclerViewAdapter;
//


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

//
//        listBooks=new ArrayList<>();
//        recyclerView =findViewById(GradeApp.R.id.bookListRecycler);
//        jsonrequest();
//
//





        //for back button
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
//
//    private void jsonrequest() {
//        RequestQueue queue= Volley.newRequestQueue(this);
//        request= new JsonArrayRequest(Request.Method.POST,URl,null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                JSONObject  jsonObject;
//                for (int i=0;i<response.length();i++){
//
//
//                    try {
//                        jsonObject =response.getJSONObject(i);
//
//                        BooksList booksList= new BooksList();
//                        booksList.setName(jsonObject.getString("name").toString());
//                        booksList.setBook_url(jsonObject.getString("bookurl").toString());
//
//                        listBooks.add(booksList);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                recyclerViewAdapter=new RecyclerViewAdapter(listBooks , getApplicationContext());
//                recyclerView.setAdapter(recyclerViewAdapter);
//
//            }
//
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("tag","onErrorResponse:"+ error.getMessage());
//
//            }
//        });
//
//
//        queue.add(request);
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
