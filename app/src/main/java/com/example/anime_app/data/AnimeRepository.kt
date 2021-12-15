package com.example.anime_app.data

import com.example.anime_app.data.api.*

interface AnimeRepository {

    suspend fun getTopList(): List<Top>?

    suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse

    suspend fun getByName(animeName: String): List<ByName>?

    suspend fun getEpisodes(animeId: Int): List<Episode>

    suspend fun getVideos(animeId: Int): List<Promo>?

    suspend fun getPictures(animeId: Int): List<Picture>?

    suspend fun getReviews(animeId: Int): List<Review>?
}