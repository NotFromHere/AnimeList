package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.data.CashWorkRepository
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

class EpisodesUseCase(
    private val animeRepository: AnimeRepository
) {

    suspend fun getEpisodes(animeId: Int): List<Episode>{
        val list = animeRepository.getEpisodes(animeId)
        return list
    }
}