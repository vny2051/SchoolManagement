package com.overseastechnologies.GradeApp;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.Call;

public interface apiset {

    @GET("login")
    Call<List<responseModel>> getdata();

    @Body()

}
