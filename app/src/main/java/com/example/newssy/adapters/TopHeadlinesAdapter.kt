package com.example.newssy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newssy.R
import com.example.newssy.data.topheadlines.Article
import kotlinx.android.synthetic.main.trending_item.view.*

class TopHeadlinesAdapter(var context: Context, var topHeadlinesList: List<Article>) :
    RecyclerView.Adapter<TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.trending_item, parent, false)
        return TopHeadlinesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        var headlineList: Article = topHeadlinesList[position]
        Glide
            .with(context)
            .load(headlineList.urlToImage)
            .centerCrop()
            .into(holder.itemView.ivTrending);
    }

    override fun getItemCount(): Int {
        return topHeadlinesList.size
    }
}

class TopHeadlinesViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)