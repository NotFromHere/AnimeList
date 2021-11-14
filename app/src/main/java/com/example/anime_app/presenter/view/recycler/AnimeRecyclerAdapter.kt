package com.example.anime_app.presenter.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.domain.entity.Anime

class AnimeRecyclerAdapter(val callback: (()->Unit)): ListAdapter<Anime, AnimeViewHolder>(
        object: DiffUtil.ItemCallback<Anime>(){
            override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                return oldItem == newItem
            }

        }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder.create(parent, callback)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}
