package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class VideoResponse(
    @SerializedName("episodes")
    var episodes: List<Episode>?,
    @SerializedName("promo")
    var promo: List<Promo>?,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?
)

data class Promo(
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("video_url")
    var videoUrl: String?
)