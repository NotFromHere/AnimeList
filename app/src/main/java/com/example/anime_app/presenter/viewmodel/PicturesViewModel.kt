package com.example.anime_app.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.data.api.Picture
import com.example.anime_app.data.api.Promo
import com.example.anime_app.domain.usecase.PicturesUseCase
import com.example.anime_app.domain.usecase.VideoUseCase
import kotlinx.coroutines.launch

class PicturesViewModel: ViewModel() {

    private val picturesUseCase: PicturesUseCase by lazy {
        AnimeRepositoryImpl().let {
            PicturesUseCase(it)
        }
    }

    val list = MutableLiveData<List<Picture>>()

    fun updateList(animeId: Int){
        viewModelScope.launch {
            val newList = picturesUseCase.getPictures(animeId)
            list.value = newList
        }
    }
}