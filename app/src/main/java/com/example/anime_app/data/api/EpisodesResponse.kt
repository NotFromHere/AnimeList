package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class EpisodesResponse(
    @SerializedName("episodes")
    var episodes: List<Episode>?,
    @SerializedName("episodes_last_page")
    var episodesLastPage: Int?,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?
)

data class Episode(
    @SerializedName("aired")
    var aired: String?,
    @SerializedName("episode_id")
    var episodeId: Int?,
    @SerializedName("filler")
    var filler: Boolean?,
    @SerializedName("forum_url")
    var forumUrl: String?,
    @SerializedName("recap")
    var recap: Boolean?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("title_japanese")
    var titleJapanese: String?,
    @SerializedName("title_romanji")
    var titleRomanji: String?,
    @SerializedName("video_url")
    var videoUrl: String?
)