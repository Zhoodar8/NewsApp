package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.newsapp.data.entity.Article;
import com.example.newsapp.data.entity.Articles;

import com.example.newsapp.data.retrofit.RetrofitBuilder;
import com.example.newsapp.news_recycler.NewsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.newsapp.data.EndPoints.API_KEY;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter = new NewsAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycler_view);
        getNews();
    }

    private void newsRecycler(List<Article> list) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.update(list);
    }

    private void getNews() {
        RetrofitBuilder.getService()
                .currentNews("us", API_KEY)
                .enqueue(new Callback<Articles>() {
                    @Override
                    public void onResponse(Call<Articles> call, Response<Articles> response) {
                        if (response.isSuccessful() && response.body()!=null){
                            Log.e("---------", response.body()+"");
                            List<Article> list = response.body().getList();
                            newsRecycler(list);

                        }


                    }

                    @Override
                    public void onFailure(Call<Articles> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });
    }
}
