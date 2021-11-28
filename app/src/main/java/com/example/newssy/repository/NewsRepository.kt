package com.example.newssy.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newssy.data.allnews.Article
import com.example.newssy.data.topheadlines.TopHeadlines
import com.example.newssy.webtools.API_KEY
import com.example.newssy.webtools.RetrofitInstance
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import retrofit2.await

class NewsRepository(application: Application) {
    var mSuccessData = MutableLiveData<Article>()
    var mFailureData = MutableLiveData<String>()

    var mSuccessHeadLines = MutableLiveData<TopHeadlines>()

    @DelicateCoroutinesApi
    fun fetchNewsData(userInput: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val news = RetrofitInstance.newsService.getNews(userInput, API_KEY).await()
            Log.e("data", "onResponse:$news")
            mSuccessData.postValue(news)

        }
    }

    fun fetchTopHeadlinesData() {
        CoroutineScope(Dispatchers.IO).launch {
            val topHeadlines=RetrofitInstance.newsService.getTrendingNews("in", "business", API_KEY).await()
            Log.e("data", "fetchTopHeadlinesData: $topHeadlines")
            mSuccessHeadLines.postValue(topHeadlines)
        }
    }
}
