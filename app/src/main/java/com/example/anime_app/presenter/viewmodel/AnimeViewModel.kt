package com.example.anime_app.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.data.CashWorkRepositoryImpl
import com.example.anime_app.domain.entity.AnimeInfo
import com.example.anime_app.domain.usecase.AnimeInfoUseCase
import com.example.anime_app.domain.usecase.AnimeLikeUseCase
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {

    private val animeUseCaseInfo : AnimeInfoUseCase by lazy {
        AnimeRepositoryImpl().let {
            AnimeInfoUseCase(it)
        }
    }

    val animeObj = MutableLiveData<AnimeInfo>()
    val title = MutableLiveData<String>()
    val score = MutableLiveData<String>()
    val rank = MutableLiveData<String>()
    val popularity = MutableLiveData<String>()
    val members = MutableLiveData<String>()
    val favorites = MutableLiveData<String>()
    val synopsis = MutableLiveData<String>()
    val type = MutableLiveData<String>()
    val status = MutableLiveData<String>()
    val episodes = MutableLiveData<String>()
    val genres = MutableLiveData<ArrayList<String>>()
    val imageUrl = MutableLiveData<String>()

    fun updateAnimeInfo(animeId: Int){
        viewModelScope.launch {
            val animeInfo = animeUseCaseInfo.getAnimeInfo(animeId)
            val nullText = "null"
            animeObj.value = animeInfo
            title.value = animeInfo.title?:nullText
            score.value = animeInfo.score?:nullText
            rank.value = animeInfo.rank?:nullText
            popularity.value = animeInfo.popularity?:nullText
            members.value = animeInfo.members?:nullText
            favorites.value = animeInfo.favorites?:nullText
            synopsis.value = animeInfo.synopsis?:nullText
            type.value = animeInfo.type?:nullText
            status.value = animeInfo.status?:nullText
            episodes.value = "Episodes " + animeInfo.episodes
            genres.value = animeInfo.genres?: arrayListOf("Null")
            imageUrl.value = animeInfo.imageUrl?:nullText
        }
    }

    fun saveAnimeLike(appContext: Context, id: Int, title: String, uri: String){
        viewModelScope.launch {
            val animeLikeUseCase = CashWorkRepositoryImpl(appContext).let {
                AnimeLikeUseCase(it)
            }
            animeLikeUseCase.saveAnimeLike(id, title, uri)
        }
    }
}