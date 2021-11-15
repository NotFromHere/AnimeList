package com.example.anime_app.data

import com.example.anime_app.data.api.AnimeInfoResponse
import com.example.anime_app.data.api.AnimeService
import com.example.anime_app.data.api.RetrofitClient
import com.example.anime_app.data.api.Top

class AnimeRepositoryImpl: AnimeRepository {

    private val animeServiceApi by lazy {
        RetrofitClient.retrofit.create(AnimeService::class.java)
    }

    override suspend fun getTopList(): List<Top>? = animeServiceApi.getAnimeList().top

    override suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse = animeServiceApi.getAnimeInfo(animeId)
}