package com.example.anime_app.data

import com.example.anime_app.data.api.*

class AnimeRepositoryImpl(): AnimeRepository {

    private val animeServiceApi by lazy {
        RetrofitClient.retrofit.create(AnimeService::class.java)
    }

    override suspend fun getTopList(): List<Top>? = animeServiceApi.getAnimeList().top
    override suspend fun getAnimeInfo(animeId: Int): AnimeInfoResponse = animeServiceApi.getAnimeInfo(animeId)
    override suspend fun getByName(animeName: String): List<ByName>? = animeServiceApi.getAnimeByName(animeName).byNames
    override suspend fun getEpisodes(animeId: Int): List<Episode> {
        val response = animeServiceApi.getEpisodes(animeId, 1)
        val list = response.episodes as ArrayList
        val pageNumber = response.episodesLastPage
        if (pageNumber != null) {
            if(pageNumber > 1) {
                for (i in 2..pageNumber){
                    val listNext = animeServiceApi.getEpisodes(animeId, i).episodes
                    if (listNext != null) {
                        list.addAll(listNext)
                    }
                }
            }
        }
        return list
    }
    override suspend fun getVideos(animeId: Int): List<Promo>? =  animeServiceApi.getVideos(animeId).promo
    override suspend fun getPictures(animeId: Int): List<Picture>? = animeServiceApi.getPictures(animeId).pictures
    override suspend fun getReviews(animeId: Int): List<Review>? = animeServiceApi.getReviews(animeId).reviews

}