package com.example.newssy.data

data class Article(
    val articles: ArrayList<News>,
    val status: String,
    val totalResults: Int
)