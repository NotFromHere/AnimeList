package com.example.anime_app.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anime_app.data.room.dao.animeDao
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

@Database(entities = [AnimeLikeFromCash::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun animeDao(): animeDao
}