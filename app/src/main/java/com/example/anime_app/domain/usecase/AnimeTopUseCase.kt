package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.domain.entity.AnimeFromTop

class AnimeTopUseCase(
    private val animeRepository: AnimeRepository
) {
    suspend fun getTopList(): List<AnimeFromTop>{
        val list = animeRepository.getTopList()
        val newList: ArrayList<AnimeFromTop> = ArrayList()
        list?.forEach { animeOfResponse ->
            val anime = AnimeFromTop(
                animeOfResponse.title,
                animeOfResponse.episodes,
                animeOfResponse.score,
                animeOfResponse.malId,
                animeOfResponse.imageUrl
            )
            newList.add(anime)
        }
        return newList.toList()
    }
}