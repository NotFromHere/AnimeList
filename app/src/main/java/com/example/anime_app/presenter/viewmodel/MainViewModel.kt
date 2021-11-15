package com.example.anime_app.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.domain.entity.AnimeFromTop
import com.example.anime_app.domain.usecase.AnimeTopUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val animeTopUseCase: AnimeTopUseCase by lazy {
        AnimeRepositoryImpl().let {
            AnimeTopUseCase(it)
        }
    }

    val list = MutableLiveData<List<AnimeFromTop>>()

    fun updateList(){
        viewModelScope.launch {
            val newList = animeTopUseCase.getTopList()
            list.value = newList
        }
    }
}