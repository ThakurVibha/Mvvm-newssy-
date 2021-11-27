package com.example.newssy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newssy.data.Article
import com.example.newssy.repository.NewsRepository

class NewsViewModel( application: Application):AndroidViewModel(application) {

    var newsRepository=NewsRepository(application)

    fun fetchNewsData(userInput: String) {
        newsRepository.fetchNewsData(userInput)
    }

    fun successData(): MutableLiveData<Article>{
       return newsRepository.mSuccessData
    }

    fun failureData():MutableLiveData<String>{
        return newsRepository.mFailureData
    }
}
