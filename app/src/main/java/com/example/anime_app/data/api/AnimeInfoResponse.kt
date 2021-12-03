package com.example.anime_app.data.api
import com.google.gson.annotations.SerializedName


data class AnimeInfoResponse(
    @SerializedName("aired")
    var aired: Aired?,
    @SerializedName("airing")
    var airing: Boolean?,
    @SerializedName("background")
    var background: Any?,
    @SerializedName("broadcast")
    var broadcast: String?,
    @SerializedName("demographics")
    var demographics: List<Demographic>?,
    @SerializedName("duration")
    var duration: String?,
    @SerializedName("ending_themes")
    var endingThemes: List<String>?,
    @SerializedName("episodes")
    var episodes: Int?,
    @SerializedName("explicit_genres")
    var explicitGenres: List<Any>?,
    @SerializedName("external_links")
    var externalLinks: List<ExternalLink>?,
    @SerializedName("favorites")
    var favorites: Int?,
    @SerializedName("genres")
    var genres: List<Genre>?,
    @SerializedName("image_url")
    var imageUrl: String?,
    @SerializedName("licensors")
    var licensors: List<Licensor>?,
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("members")
    var members: Int?,
    @SerializedName("opening_themes")
    var openingThemes: List<String>?,
    @SerializedName("popularity")
    var popularity: Int?,
    @SerializedName("premiered")
    var premiered: String?,
    @SerializedName("producers")
    var producers: List<Producer>?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("rating")
    var rating: String?,
    @SerializedName("related")
    var related: Related?,
    @SerializedName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    var requestCached: Boolean?,
    @SerializedName("request_hash")
    var requestHash: String?,
    @SerializedName("score")
    var score: Double?,
    @SerializedName("scored_by")
    var scoredBy: Int?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("studios")
    var studios: List<Studio>?,
    @SerializedName("synopsis")
    var synopsis: String?,
    @SerializedName("themes")
    var themes: List<Theme>?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("title_english")
    var titleEnglish: String?,
    @SerializedName("title_japanese")
    var titleJapanese: String?,
    @SerializedName("title_synonyms")
    var titleSynonyms: List<String>?,
    @SerializedName("trailer_url")
    var trailerUrl: Any?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Aired(
    @SerializedName("from")
    var from: String?,
    @SerializedName("prop")
    var prop: Prop?,
    @SerializedName("string")
    var string: String?,
    @SerializedName("to")
    var to: String?
)

data class Demographic(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class ExternalLink(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)

data class Genre(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Licensor(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Producer(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Related(
    @SerializedName("Adaptation")
    var adaptation: List<Adaptation>?,
    @SerializedName("Sequel")
    var sequel: List<Sequel>?
)

data class Studio(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Theme(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Prop(
    @SerializedName("from")
    var from: From?,
    @SerializedName("to")
    var to: To?
)

data class From(
    @SerializedName("day")
    var day: Int?,
    @SerializedName("month")
    var month: Int?,
    @SerializedName("year")
    var year: Int?
)

data class To(
    @SerializedName("day")
    var day: Int?,
    @SerializedName("month")
    var month: Int?,
    @SerializedName("year")
    var year: Int?
)

data class Adaptation(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)

data class Sequel(
    @SerializedName("mal_id")
    var malId: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("url")
    var url: String?
)