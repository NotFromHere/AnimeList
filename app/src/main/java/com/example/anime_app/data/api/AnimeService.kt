package com.example.anime_app.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
    @GET("top/anime/1")
    suspend fun getAnimeList(): AnimeTopResponse

    @GET("anime/{id}")
    suspend fun getAnimeInfo(@Path("id")animeId: Int): AnimeInfoResponse

}