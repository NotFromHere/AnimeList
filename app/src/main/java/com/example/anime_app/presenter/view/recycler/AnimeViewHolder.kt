package com.example.anime_app.presenter.view.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.domain.entity.AnimeFromTop
import com.squareup.picasso.Picasso

class AnimeViewHolder(
        val containerView: View,
        val callback: ((x: Int)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    fun bind(animeFromTop: AnimeFromTop){
        setData(animeFromTop)
        containerView.setOnClickListener {
            animeFromTop.mal_id?.let { it1 -> callback.invoke(it1) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(animeFromTop: AnimeFromTop) {
        containerView.findViewById<TextView>(R.id.tv_rv_anime_title).text = animeFromTop.name
        containerView.findViewById<TextView>(R.id.textView_vh_rating).text = animeFromTop.rating.toString()
        containerView.findViewById<TextView>(R.id.textView_vh_episodes).text = animeFromTop.episodes.toString() + " episodes"
        containerView.findViewById<TextView>(R.id.tv_type).text = animeFromTop.type.toString()
        Picasso.get()
            .load(animeFromTop.url)
            .placeholder(R.drawable.anime_list_logo)
            .error(R.drawable.ic_home_black_24dp)
            .fit()
            .into(containerView.findViewById<ImageView>(R.id.imageView_vh))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: Int)-> Unit)): AnimeViewHolder {
            return AnimeViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.viewholder_anime, parent, false), callback)
        }
    }
}
