package com.example.newssy.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newssy.data.Article
import com.example.newssy.webtools.API_KEY
import com.example.newssy.webtools.RetrofitInstance
import kotlinx.coroutines.*
import retrofit2.await

class NewsRepository(application: Application) {
    var mSuccessData = MutableLiveData<Article>()
    var mFailureData = MutableLiveData<String>()


    @DelicateCoroutinesApi
    fun fetchNewsData(userInput: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var news = RetrofitInstance.newsService.getNews(userInput, API_KEY).await()
            Log.e("data", "onResponse:$news")
            mSuccessData.postValue(news)

        }
    }
}
