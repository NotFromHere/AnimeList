package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class AnimeResponse(
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?,
    @SerializedName("top")
    var top: List<Top>?
)

data class Top(
    @SerializedName("end_date")
    var endDate: String?,
    @SerializedName("episodes")
    var episodes: Int?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("members")
    var members: Int?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("score")
    var score: Double?,
    @SerializedName("start_date")
    var startDate: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)