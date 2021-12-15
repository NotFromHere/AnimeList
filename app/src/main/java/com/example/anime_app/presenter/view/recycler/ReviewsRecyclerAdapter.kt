package com.example.anime_app.presenter.view.recycler

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.anime_app.data.api.Review

class ReviewsRecyclerAdapter(val callback: ((x: String)-> Unit)): ListAdapter<Review, ReviewsViewHolder>(
    object: DiffUtil.ItemCallback<Review>(){
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.reviewer == newItem.reviewer
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        return ReviewsViewHolder.create(parent, callback)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        holder.bind(currentList.get(position))
    }
}