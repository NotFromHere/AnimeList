package com.example.anime_app.presenter.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

class EpisodesRecyclerAdapter(val callback: ((x: String)-> Unit)): ListAdapter<Episode, EpisodesViewHolder>(
    object: DiffUtil.ItemCallback<Episode>(){
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        return EpisodesViewHolder.create(parent, callback)
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}