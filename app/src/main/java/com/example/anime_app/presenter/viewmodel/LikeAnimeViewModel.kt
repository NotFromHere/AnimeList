package com.example.anime_app.presenter.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.CashWorkRepositoryImpl
import com.example.anime_app.data.room.entity.AnimeLikeFromCash
import com.example.anime_app.domain.usecase.AnimeLikeUseCase
import kotlinx.coroutines.launch

class LikeAnimeViewModel: ViewModel() {

    val list = MutableLiveData<List<AnimeLikeFromCash>>()

    fun updateList(appContext: Context){
        viewModelScope.launch {
            val animeLikeUseCase = CashWorkRepositoryImpl(appContext).let { AnimeLikeUseCase(it) }
            val newList = animeLikeUseCase.getAnimeLike()
            list.value = newList
        }
    }
}