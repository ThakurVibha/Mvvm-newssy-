package com.example.newssy.webtools
import com.example.newssy.data.allnews.Article
import com.example.newssy.data.topheadlines.TopHeadlines
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "Your_API_KEY"

interface NewsService {
    @GET("v2/everything")
   fun getNews(@Query("q") query: String, @Query("apiKey") api_key: String): Call<Article>

   @GET("v2/top-headlines")
   fun getTrendingNews(@Query ("country") country: String, @Query("category")category :String ,@Query ("apiKey") api_key: String):Call<TopHeadlines>

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