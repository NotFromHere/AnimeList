package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Picture

class PicturesUseCase(
    private val animeRepository: AnimeRepository
) {

    suspend fun getPictures(animeId: Int): List<Picture>{
        val list = animeRepository.getPictures(animeId)
        return list?: arrayListOf()
    }
}