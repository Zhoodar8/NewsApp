package com.example.newsapp.news_recycler;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;

import com.example.newsapp.data.entity.Article;
import com.example.newsapp.data.entity.Articles;


public class NewsViewHolder extends RecyclerView.ViewHolder {

    private TextView txt_news;
    private ImageView img_news;
    private TextView txt_desc;
    private NewsInterface newsInterface;
    private int position;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_news=itemView.findViewById(R.id.txt_news);
        img_news=itemView.findViewById(R.id.img_news);
        txt_desc =itemView.findViewById(R.id.txt_desc);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsInterface.onClickListener(position);
            }
        });
    }

    public void onBind(Article news, int position) {
        txt_news.setText(news.getTitle());
        txt_desc.setText(news.getDescription());
        Glide.with(itemView.getContext()).load(news.getUrlToImage()).into(img_news);
        this.position=position;
    }

    public void setOnclickListener(NewsInterface newsInterface) {
        this.newsInterface = newsInterface;
    }
}
