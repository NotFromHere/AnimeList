package com.example.anime_app.data

import android.content.Context
import androidx.room.Room
import com.example.anime_app.data.api.*
import com.example.anime_app.data.room.AppDatabase
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

class AnimeRepositoryImpl(): AnimeRepository {

    private val animeServiceApi by lazy {
        RetrofitClient.retrofit.create(AnimeService::class.java)
    }

    override suspend fun getTopList(): List<Top>? = animeServiceApi.getAnimeList().top
    override suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse = animeServiceApi.getAnimeInfo(animeId)
    override suspend fun getByName(animeName: String): List<ByName>? = animeServiceApi.getAnimeByName(animeName).byNames
}