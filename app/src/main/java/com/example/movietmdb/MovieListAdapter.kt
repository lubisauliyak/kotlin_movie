package com.example.movietmdb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietmdb.data.ResultsItem
import com.squareup.picasso.Picasso

class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    val todoList: MutableList<ResultsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_movie_holder, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data = todoList[position]
        holder.tvTitle.text = data.title
        holder.tvRate.text = data.voteAverage.toString()
        holder.tvPopularity.text = data.popularity.toString()
        holder.tvDate.text = data.releaseDate
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${data.posterPath}").into(holder.ivCover)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    fun setNewData(data: List<ResultsItem>) {
        todoList.clear()
        todoList.addAll(data)
        notifyDataSetChanged()
    }
}