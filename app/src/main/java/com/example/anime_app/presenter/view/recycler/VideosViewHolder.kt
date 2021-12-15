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
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Promo
import com.squareup.picasso.Picasso
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class VideosViewHolder(
    val containerView: View,
    val callback: ((x: String)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(promo: Promo){
        setData(promo)
        containerView.setOnClickListener {
            var text = promo.videoUrl?.subSequence(30, 41).toString()
            callback.invoke(text)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun setData(promo: Promo) {
        containerView.findViewById<TextView>(R.id.tv_video_title).text = promo.title
        Picasso.get()
            .load(promo.imageUrl)
            .placeholder(R.drawable.anime_list_logo)
            .error(R.drawable.ic_home_black_24dp)
            .fit()
            .into(containerView.findViewById<ImageView>(R.id.imageView_video))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: String)-> Unit)): VideosViewHolder {
            return VideosViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_video_item, parent, false), callback)
        }
    }
}