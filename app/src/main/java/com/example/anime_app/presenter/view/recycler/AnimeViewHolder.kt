package com.example.anime_app.presenter.view.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R

class AnimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView
    val textView: TextView

    init {
        imageView = itemView.findViewById(R.id.vh_imageView)
        textView = itemView.findViewById(R.id.vh_textView)
    }
}
