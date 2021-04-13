package com.example.anime_app.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.anime_app.R
import com.example.anime_app.data.AnimeRepositoryImpl
import com.example.anime_app.domain.usecase.AnimeTopUseCase
import com.example.anime_app.presenter.view.recycler.AnimeRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class MainActivity : AppCompatActivity() {

    private val adapter = AnimeRecyclerAdapter()

    private val mainViewModel: MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        rv_main.adapter = adapter
        firstInitList()
        initSub()
    }

    private fun initSub() {
        mainViewModel.list.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun firstInitList() {
        mainViewModel.updateList()
    }
}