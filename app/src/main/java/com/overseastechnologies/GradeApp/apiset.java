package com.overseastechnologies.GradeApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface apiset {

    @POST("login")
     @Headers({
             "Content-Type: application/json",
             "Developerkey: schlMana20Ge22"
     })


    Call<List<responseModel>> getdata();
}
