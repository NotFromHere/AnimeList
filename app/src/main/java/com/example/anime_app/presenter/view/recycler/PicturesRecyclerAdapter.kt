package com.example.anime_app.presenter.view.recycler

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.data.api.Picture

class PicturesRecyclerAdapter (val callback: ((x: String)-> Unit)): ListAdapter<Picture, PicturesViewHolder>(
    object: DiffUtil.ItemCallback<Picture>(){
        override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            return oldItem.large == newItem.large
        }

        override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        return PicturesViewHolder.create(parent, callback)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}