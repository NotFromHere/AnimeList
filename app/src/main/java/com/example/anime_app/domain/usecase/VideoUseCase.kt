package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Promo

class VideoUseCase(
private val animeRepository: AnimeRepository
) {

    suspend fun getVideos(animeId: Int): List<Promo>?{
        val list = animeRepository.getVideos(animeId)
        return list
    }
}