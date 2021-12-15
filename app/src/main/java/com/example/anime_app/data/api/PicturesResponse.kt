package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class PicturesResponse(
    @SerializedName("pictures")
    var pictures: List<Picture>?,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?
)

data class Picture(
    @SerializedName("large")
    var large: String?,
    @SerializedName("small")
    var small: String?
)