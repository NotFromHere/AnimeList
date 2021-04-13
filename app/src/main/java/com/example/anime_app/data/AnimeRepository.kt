package com.example.anime_app.data

import com.example.anime_app.data.api.AnimeResponse
import com.example.anime_app.data.api.Top

interface AnimeRepository {

    suspend fun getTop50List(): List<Top>?
}