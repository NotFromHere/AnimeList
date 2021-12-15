package com.example.anime_app.presenter.view.recycler

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.R
import com.example.anime_app.data.api.Picture
import com.squareup.picasso.Picasso

class PicturesViewHolder (
    val containerView: View,
    val callback: ((x: String)-> Unit)
) : RecyclerView.ViewHolder(containerView){

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(picture: Picture){
        setData(picture)
        containerView.setOnClickListener {
            callback.invoke("123")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    private fun setData(picture: Picture) {
        Picasso.get()
            .load(picture.large)
            .placeholder(R.drawable.anime_list_logo)
            .error(R.drawable.ic_home_black_24dp)
            .fit()
            .into(containerView.findViewById<ImageView>(R.id.imageView_picture))
    }

    companion object {
        fun create(parent: ViewGroup, callback: ((x: String)-> Unit)): PicturesViewHolder {
            return PicturesViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_pictures, parent, false), callback)
        }
    }
}