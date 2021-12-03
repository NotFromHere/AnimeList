package com.example.anime_app.domain.usecase

import com.example.anime_app.data.AnimeRepository
import com.example.anime_app.data.CashWorkRepository
import com.example.anime_app.data.room.entity.AnimeLikeFromCash
import com.example.anime_app.domain.entity.AnimeFromTop

class AnimeLikeUseCase(
    private val cashWorkRepository: CashWorkRepository
) {

    suspend fun getAnimeLike(): List<AnimeLikeFromCash>{
        val list = cashWorkRepository.getAnimeLike()
        return list
    }

    suspend fun saveAnimeLike(id: Int, title: String, uri: String){
        val animeObj = AnimeLikeFromCash(id, title, uri)
        cashWorkRepository.saveAnimeLike(animeObj)
    }
}