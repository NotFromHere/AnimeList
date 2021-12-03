package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.domain.entity.AnimeInfo
import java.util.concurrent.TimeUnit

class AnimeInfoUseCase(
    private val animeRepository: AnimeRepository
) {
    suspend fun getAnimeInfo(animeId: Int): AnimeInfo{
        val animeObj = animeRepository.getAnimeInfo(animeId)
        val animeGenres: ArrayList<String> = ArrayList()
        animeObj.genres?.forEach {
            it.name?.let { it1 -> animeGenres.add(it1) }
        }
        val animeInfo: AnimeInfo =
            AnimeInfo(
                animeObj.title,
                animeObj.score.toString(),
                animeObj.rank.toString(),
                animeObj.popularity.toString(),
                animeObj.members.toString(),
                animeObj.favorites.toString(),
                animeObj.synopsis.toString(),
                animeObj.type.toString(),
                animeObj.status.toString(),
                animeObj.episodes.toString(),
                animeGenres,
                animeObj.imageUrl
        )
        return animeInfo
    }
}