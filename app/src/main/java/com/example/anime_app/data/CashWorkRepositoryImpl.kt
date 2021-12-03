package com.example.anime_app.data

import android.content.Context
import androidx.room.Room
import com.example.anime_app.data.room.AppDatabase
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

class CashWorkRepositoryImpl(
    private val appContext: Context
): CashWorkRepository {

    private val dao by lazy{
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "AnimeListDB"
        ).build().animeDao()
    }

    override suspend fun getAnimeLike(): List<AnimeLikeFromCash> = dao.loadAllAnime()
    override suspend fun saveAnimeLike(animeObj: AnimeLikeFromCash) {
        dao.insertAnime(animeObj)
    }
}