package com.example.anime_app.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {
    @GET("top/anime/1")
    suspend fun getAnimeList(): AnimeTopResponse

    @GET("anime/{id}")
    suspend fun getAnimeInfo(@Path("id")animeId: Int): AnimeInfoResponse

    @GET("search/anime?page=1")
    suspend fun getAnimeByName(@Query("q")animeName: String): AnimeByNameResponse

    @GET("anime/{id}/episodes/{page}")
    suspend fun getEpisodes(@Path("id")animeId: Int, @Path("page")page: Int): EpisodesResponse

}