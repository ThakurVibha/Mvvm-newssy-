package com.example.newssy.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newssy.R
import com.example.newssy.data.News
import com.example.newssy.view.DetailsActivity
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(
    var context: Context, var newsDataList: List<News>
) :
    RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var list: News = newsDataList[position]
        holder.itemView.tvTitle.text = list.title
        holder.itemView.tvAuthor.text = list.author
        holder.itemView.tvDate.text = list.publishedAt
        Glide
            .with(context)
            .load(list.urlToImage)
            .centerCrop()
            .into(holder.image);

        holder.itemView.setOnClickListener {
            Intent(context, DetailsActivity::class.java).let {
                context.startActivity(it)
            }
        }


    }

    override fun getItemCount(): Int {
        return newsDataList.size
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image = itemView.findViewById<ImageView>(R.id.ivNews)
}