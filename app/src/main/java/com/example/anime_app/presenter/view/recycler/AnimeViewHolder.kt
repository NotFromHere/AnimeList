package com.example.anime_app.presenter.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.domain.entity.Anime

class AnimeViewHolder(
        val containerView: View,
        val callback: (()->Unit)
) : RecyclerView.ViewHolder(containerView){

    fun bind(anime: Anime){
        setData(anime)
        containerView.setOnClickListener {
            callback.invoke()
        }
    }

    private fun setData(anime: Anime) {
        containerView.findViewById<TextView>(R.id.textView_vh_name).text = anime.name
        containerView.findViewById<TextView>(R.id.textView_vh_rating).text = anime.rating.toString()
        containerView.findViewById<TextView>(R.id.textView_vh_episodes).text =
            anime.episodes.toString()
    }

    companion object {
        fun create(parent: ViewGroup, callback: (()->Unit)): AnimeViewHolder {
            return AnimeViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.viewholder_anime, parent, false), callback)
        }
    }
}
