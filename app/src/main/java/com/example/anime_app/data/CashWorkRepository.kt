package com.example.anime_app.data

import com.example.anime_app.data.room.entity.AnimeLikeFromCash

interface CashWorkRepository {

    suspend fun getAnimeLike(): List<AnimeLikeFromCash>

    suspend fun saveAnimeLike(animeObj: AnimeLikeFromCash)
}