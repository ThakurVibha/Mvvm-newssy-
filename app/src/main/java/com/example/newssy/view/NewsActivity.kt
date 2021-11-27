package com.example.newssy.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newssy.R
import com.example.newssy.adapters.NewsAdapter
import com.example.newssy.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initApi()
        setObserver()
    }


    private fun initApi() {
        ivDone.setOnClickListener {
            newsViewModel.fetchNewsData(edtInput.text.toString())
            if (edtInput.text.toString().isEmpty()) {
                edtInput.error = "Enter some topic"
            }
        }

    }

    private fun setObserver() {
        newsViewModel.successData().observe(this, Observer {
            newsAdapter = NewsAdapter(this, it.articles)
            rvNews.adapter = newsAdapter
            rvNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        })
        newsViewModel.failureData().observe(this, Observer {
            var failureMessage = it.toString()
            Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show()
        })
    }

    fun initViewModel() {
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

    }

}