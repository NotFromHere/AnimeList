package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class ReviewsResponse(
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?,
    @SerializedName("reviews")
    var reviews: List<Review>?
)

data class Review(
    @SerializedName("content")
    var content: String?,
    @SerializedName("date")
    var date: String?,
    @SerializedName("helpful_count")
    var helpfulCount: Int?,
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("reviewer")
    var reviewer: Reviewer?,
    @SerializedName("type")
    var type: Any?,
    @SerializedName("url")
    var url: String?
)

data class Reviewer(
    @SerializedName("episodes_seen")
    var episodesSeen: Int?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("scores")
    var scores: Scores?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("username")
    var username: String?
)

data class Scores(
    @SerializedName("animation")
    var animation: Int?,
    @SerializedName("character")
    var character: Int?,
    @SerializedName("enjoyment")
    var enjoyment: Int?,
    @SerializedName("overall")
    var overall: Int?,
    @SerializedName("sound")
    var sound: Int?,
    @SerializedName("story")
    var story: Int?
)