package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class AnimeByNameResponse(
    @SerializedName("last_page")
    var lastPage: Int?,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?,
    @SerializedName("results")
    var byNames: List<ByName>?
)

data class ByName(
    @SerializedName("airing")
    var airing: Boolean?,
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
    @SerializedName("rated")
    var rated: String?,
    @SerializedName("score")
    var score: Double?,
    @SerializedName("start_date")
    var startDate: String?,
    @SerializedName("synopsis")
    var synopsis: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)