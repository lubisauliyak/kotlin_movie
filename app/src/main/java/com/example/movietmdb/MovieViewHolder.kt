package com.example.movietmdb

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val ivCover = view.findViewById<ImageView>(R.id.iv_cover)
    val tvTitle = view.findViewById<TextView>(R.id.tv_title)
    val tvRate = view.findViewById<TextView>(R.id.tv_rate)
    val tvPopularity = view.findViewById<TextView>(R.id.tv_popularity)
    val tvDate = view.findViewById<TextView>(R.id.tv_date)

}