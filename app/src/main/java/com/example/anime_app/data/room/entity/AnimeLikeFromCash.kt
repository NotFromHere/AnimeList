package com.example.anime_app.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_like")
data class AnimeLikeFromCash(
    @PrimaryKey(autoGenerate = true)var anime_id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "uri") var img_uri: String
)
