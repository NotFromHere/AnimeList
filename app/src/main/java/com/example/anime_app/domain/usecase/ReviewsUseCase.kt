package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.data.api.Picture
import com.example.anime_app.data.api.Review

class ReviewsUseCase(
    private val animeRepository: AnimeRepository
) {

    suspend fun getReviews(animeId: Int): List<Review>{
        val list = animeRepository.getReviews(animeId)
        return list?: arrayListOf()
    }
}