package com.example.anime_app.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.domain.entity.AnimeFromTop
import com.example.anime_app.domain.usecase.AnimeByNameUseCase
import com.example.anime_app.domain.usecase.AnimeTopUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val animeTopUseCase: AnimeTopUseCase by lazy {
        AnimeRepositoryImpl().let {
            AnimeTopUseCase(it)
        }
    }

    private val animeByNameUseCase: AnimeByNameUseCase by lazy {
        AnimeRepositoryImpl().let {
            AnimeByNameUseCase(it)
        }
    }

    val list = MutableLiveData<List<AnimeFromTop>>()
    val listByName = MutableLiveData<List<AnimeFromTop>>()

    fun updateList(){
        viewModelScope.launch {
            val newList = animeTopUseCase.getTopList()
            list.value = newList
        }
    }

    fun getByName(animeName: String){
        viewModelScope.launch {
            val newList = animeByNameUseCase.getByName(animeName)
            listByName.value = newList
        }
    }
}