package com.example.newsapp.news_recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import com.example.newsapp.WebViewActivity;
import com.example.newsapp.data.entity.Article;
import com.example.newsapp.data.entity.Articles;


import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> implements NewsInterface {

    private List<Article> list = new ArrayList<>();
    private Context context;


    public NewsAdapter(Context context) {
        this.context = context;
    }

   public void update(List<Article> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.view_holder, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);

        newsViewHolder.setOnclickListener(this);


        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.onBind(list.get(position), position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url",list.get(position).getUrl());
        context.startActivity(intent);
    }
}
