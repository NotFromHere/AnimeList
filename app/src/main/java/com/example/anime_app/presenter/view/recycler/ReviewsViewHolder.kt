package com.example.anime_app.presenter.view.recycler

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.data.api.Promo
import com.example.anime_app.data.api.Review
import com.squareup.picasso.Picasso
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class ReviewsViewHolder(
    val containerView: View,
    val callback: ((x: String)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(review: Review){
        setData(review)
        containerView.setOnClickListener {
            callback.invoke(review.content.toString())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun setData(review: Review) {
        containerView.findViewById<TextView>(R.id.tv_reviews_reviewer).text =
            review.reviewer?.username ?: "null"
        containerView.findViewById<TextView>(R.id.tv_reviews_date).text = OffsetDateTime.parse(review.date).format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: String)-> Unit)): ReviewsViewHolder {
            return ReviewsViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_reviews, parent, false), callback)
        }
    }
}