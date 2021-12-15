package com.example.anime_app.presenter.view.recycler

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.data.api.Episode
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class EpisodesViewHolder(
    val containerView: View,
    val callback: ((x: String)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(episode: Episode){
        setData(episode)
        containerView.setOnClickListener {
            episode.videoUrl?.let { it1 -> callback.invoke(it1) }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun setData(episode: Episode) {
        containerView.findViewById<TextView>(R.id.tv_episode_number).text = episode.episodeId.toString()
        containerView.findViewById<TextView>(R.id.tv_episode_title).text = episode.title
        containerView.findViewById<TextView>(R.id.tv_episode_title_romanji).text = episode.titleRomanji
        containerView.findViewById<TextView>(R.id.tv_episode_title_japanese).text = "(" + episode.titleJapanese + ")"
        containerView.findViewById<TextView>(R.id.tv_episode_data).text = OffsetDateTime.parse(episode.aired).format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: String)-> Unit)): EpisodesViewHolder {
            return EpisodesViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_episode_item, parent, false), callback)
        }
    }
}