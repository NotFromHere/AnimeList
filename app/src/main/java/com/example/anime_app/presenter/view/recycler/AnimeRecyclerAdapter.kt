package com.example.anime_app.presenter.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.domain.entity.AnimeFromTop

class AnimeRecyclerAdapter(val callback: ((x: Int)-> Unit)): ListAdapter<AnimeFromTop, AnimeViewHolder>(
        object: DiffUtil.ItemCallback<AnimeFromTop>(){
            override fun areItemsTheSame(oldItem: AnimeFromTop, newItem: AnimeFromTop): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: AnimeFromTop, newItem: AnimeFromTop): Boolean {
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
