package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.domain.entity.Anime

class AnimeTopUseCase(
    private val animeRepository: AnimeRepository
) {
    fun getTopList(): List<Anime>{
        val list = animeRepository.getTop50List()
        val newList: ArrayList<Anime> = ArrayList()
        list?.forEach { animeOfResponse ->
            val anime = Anime(
                animeOfResponse.title,
                animeOfResponse.episodes,
                animeOfResponse.score)
            newList.add(anime)
        }
        return newList.toList()
    }
}