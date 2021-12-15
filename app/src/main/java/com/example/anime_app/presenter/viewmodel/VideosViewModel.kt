package com.example.anime_app.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.api.Promo
import com.example.anime_app.domain.usecase.EpisodesUseCase
import com.example.anime_app.domain.usecase.VideoUseCase
import kotlinx.coroutines.launch

class VideosViewModel : ViewModel() {

    private val videoUseCase: VideoUseCase by lazy {
        AnimeRepositoryImpl().let {
            VideoUseCase(it)
        }
    }

    val list = MutableLiveData<List<Promo>>()

    fun updateList(animeId: Int){
        viewModelScope.launch {
            val newList = videoUseCase.getVideos(animeId)
            list.value = newList?: arrayListOf()
        }
    }
}