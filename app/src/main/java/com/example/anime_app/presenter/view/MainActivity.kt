package com.example.anime_app.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anime_app.R
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.domain.usecase.AnimeTopUseCase
import com.example.anime_app.presenter.view.recycler.AnimeRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class MainActivity : AppCompatActivity() {
    private val animeTopUseCase: AnimeTopUseCase by lazy {
        AnimeRepositoryImpl().let {
            AnimeTopUseCase(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        rv_main.adapter = AnimeRecyclerAdapter()
        firstInitList()
    }

    private fun firstInitList() {
        CoroutineScope(Dispatchers.Main).launch {
            val list = animeTopUseCase.getTopList()
            (rv_main.adapter as AnimeRecyclerAdapter).submitList(list)
        }
    }
}