package com.example.newssy.webtools

import com.example.newssy.data.Article
import com.example.newssy.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "YOUR_API_KEY"


interface NewsService {

    @GET("v2/everything")
   fun getNews(@Query("q") query: String, @Query("apiKey") api_key: String): Call<Article>

}

object RetrofitInstance {
    var newsService: NewsService

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        //interface for implementation
        newsService = retrofit.create(NewsService::class.java)

    }
}