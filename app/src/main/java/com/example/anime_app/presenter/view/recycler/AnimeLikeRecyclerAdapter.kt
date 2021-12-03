package com.example.anime_app.presenter.view.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.data.room.entity.AnimeLikeFromCash
import com.example.anime_app.domain.entity.AnimeFromTop

class AnimeLikeRecyclerAdapter(val callback: ((x: Int)-> Unit)): ListAdapter<AnimeLikeFromCash, AnimeLikeViewHolder>(
    object: DiffUtil.ItemCallback<AnimeLikeFromCash>(){
        override fun areItemsTheSame(oldItem: AnimeLikeFromCash, newItem: AnimeLikeFromCash): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AnimeLikeFromCash, newItem: AnimeLikeFromCash): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeLikeViewHolder {
        return AnimeLikeViewHolder.create(parent, callback)
    }

    override fun onBindViewHolder(holder: AnimeLikeViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}