package com.example.newsapp.data.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Articles {

    @SerializedName("articles")
    @Expose

    private List<Article> list;

    public List<Article> getList() {
        return list;
    }

    public Articles(List<Article> list) {
        this.list = list;
    }
}
