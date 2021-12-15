package com.example.anime_app.presenter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.data.api.Review
import com.example.anime_app.domain.usecase.ReviewsUseCase
import kotlinx.coroutines.launch

class ReviewsModelView: ViewModel() {

    private val reviewsUseCase: ReviewsUseCase by lazy {
        AnimeRepositoryImpl().let {
            ReviewsUseCase(it)
        }
    }

    val list = MutableLiveData<List<Review>>()

    fun updateList(animeId: Int){
        viewModelScope.launch {
            val newList = reviewsUseCase.getReviews(animeId)
            list.value = newList
        }
    }
}