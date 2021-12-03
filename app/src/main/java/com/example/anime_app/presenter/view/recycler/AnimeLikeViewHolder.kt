package com.example.anime_app.presenter.view.recycler

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.data.room.entity.AnimeLikeFromCash
import com.example.anime_app.domain.entity.AnimeFromTop
import org.w3c.dom.Text

class AnimeLikeViewHolder(
    val containerView: View,
    val callback: ((x: Int)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    fun bind(animeLikeFromCash: AnimeLikeFromCash){
        setData(animeLikeFromCash)
        containerView.setOnClickListener {
            animeLikeFromCash.anime_id.let { it1 -> callback.invoke(it1) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(animeLikeFromCash: AnimeLikeFromCash) {
        containerView.findViewById<TextView>(R.id.tv_anime_like_title).text = animeLikeFromCash.name
        containerView.findViewById<ImageView>(R.id.imageView_anime_like).setImageURI(Uri.parse(animeLikeFromCash.img_uri))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: Int)-> Unit)): AnimeLikeViewHolder {
            return AnimeLikeViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_anime_like, parent, false), callback)
        }
    }
}