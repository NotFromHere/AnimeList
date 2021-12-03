package com.example.anime_app.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.anime_app.data.room.entity.AnimeLikeFromCash

@Dao
interface animeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(animeLike: AnimeLikeFromCash)

    @Delete
    suspend fun deleteAnime(animeLike: AnimeLikeFromCash)

    @Query("SELECT * FROM anime_like")
    suspend fun loadAllAnime(): List<AnimeLikeFromCash>
}