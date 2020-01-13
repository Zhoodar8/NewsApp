package com.example.newsapp.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.newsapp.data.EndPoints.URL;

public class RetrofitBuilder {

    private static RetrofitService retrofitService;

    public static RetrofitService getService(){
        if (retrofitService == null){
            retrofitService = buildRetrofit();
        }
        return retrofitService;
    }


    private  static RetrofitService buildRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);



    }
}
