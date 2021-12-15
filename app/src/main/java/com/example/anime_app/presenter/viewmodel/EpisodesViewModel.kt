package com.example.anime_app.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.data.CashWorkRepositoryImpl
import com.example.anime_app.data.api.Episode
import com.example.anime_app.data.room.entity.AnimeLikeFromCash
import com.example.anime_app.domain.usecase.AnimeLikeUseCase
import com.example.anime_app.domain.usecase.AnimeTopUseCase
import com.example.anime_app.domain.usecase.EpisodesUseCase
import kotlinx.coroutines.launch

class EpisodesViewModel: ViewModel() {

    private val episodesUseCase: EpisodesUseCase by lazy {
        AnimeRepositoryImpl().let {
            EpisodesUseCase(it)
        }
    }

    val list = MutableLiveData<List<Episode>>()

    fun updateList(animeId: Int){
        viewModelScope.launch {
            val newList = episodesUseCase.getEpisodes(animeId)
            list.value = newList
        }
    }
}