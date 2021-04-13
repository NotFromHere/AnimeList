package com.example.anime_app.data

import com.example.anime_app.data.api.AnimeResponse
import com.example.anime_app.data.api.AnimeService
import com.example.anime_app.data.api.RetrofitClient
import com.example.anime_app.data.api.Top

class AnimeRepositoryImpl: AnimeRepository {

    private val animeServiceApi by lazy {
        RetrofitClient.retrofit.create(AnimeService::class.java)
    }

    override suspend fun getTop50List(): List<Top>? = animeServiceApi.getTop50List().top

}