package com.example.anime_app.domain.entity

import com.example.anime_app.data.api.Genre

data class AnimeInfo(
    val title: String?,
    val score: String?,
    val rank: String?,
    val popularity: String?,
    val members: String?,
    val favorites: String?,
    val synopsis: String?,
    val type: String?,
    val status: String?,
    val episodes: String?,
    val genres: ArrayList<String>?,
    val imageUrl: String?
)
