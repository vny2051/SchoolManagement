package com.overseastechnologies.GradeApp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController {

    private static final String url = "http://192.168.43.53/api/loginApi1.php";
    private static apiController clientobject;
    private static Retrofit retrofit;

    apiController() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apiController getInstance() {
        if (clientobject == null)
            clientobject = new apiController();

        return clientobject;
    }

    public apiset getapi(){
        return retrofit.create(apiset.class);
    }
}
