package com.example.anime_app.data.api

import retrofit2.http.GET

interface AnimeService {
    @GET("/top/anime/1")
    fun getTop50List(): AnimeResponse
}