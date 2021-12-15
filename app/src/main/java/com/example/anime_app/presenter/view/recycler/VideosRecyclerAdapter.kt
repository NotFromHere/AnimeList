package com.example.anime_app.presenter.view.recycler

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Promo

class VideosRecyclerAdapter(val callback: ((x: String)-> Unit)): ListAdapter<Promo, VideosViewHolder>(
    object: DiffUtil.ItemCallback<Promo>(){
        override fun areItemsTheSame(oldItem: Promo, newItem: Promo): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Promo, newItem: Promo): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder.create(parent, callback)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}