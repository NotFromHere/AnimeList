package com.example.anime_app.data

import com.example.anime_app.data.api.AnimeInfoResponse
import com.example.anime_app.data.api.Top

interface AnimeRepository {

    suspend fun getTopList(): List<Top>?

    suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse
}