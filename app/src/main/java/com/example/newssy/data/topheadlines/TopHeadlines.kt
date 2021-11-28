package com.example.newssy.data.topheadlines

data class TopHeadlines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)