package com.example.anime_app.presenter.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.domain.entity.Anime
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_anime.view.*

class AnimeViewHolder(
        override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(anime: Anime){
        containerView.textView_vh_name.text = anime.name
        containerView.textView_vh_rating.text = anime.rating.toString()
        containerView.textView_vh_episodes.text = anime.episodes.toString()
    }

    companion object {
        fun create(parent: ViewGroup): AnimeViewHolder {
            return AnimeViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.viewholder_anime, parent, false))
        }
    }
}
