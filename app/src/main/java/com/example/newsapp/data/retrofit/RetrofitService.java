package com.example.newsapp.data.retrofit;



import com.example.CurrentNews;
import com.example.newsapp.data.entity.Articles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.newsapp.data.EndPoints.TOP_HEAD_LINE;

public interface RetrofitService {


    @GET(TOP_HEAD_LINE)
    Call<Articles> currentNews(@Query("country")String country, @Query("apiKey") String key);

}
