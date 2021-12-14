package com.example.anime_app.data

import com.example.anime_app.data.api.AnimeInfoResponse
import com.example.anime_app.data.api.ByName
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Top
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

interface AnimeRepository {

    suspend fun getTopList(): List<Top>?

    suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse

    suspend fun getByName(animeName: String): List<ByName>?

    suspend fun getEpisodes(animeId: Int): List<Episode>
}