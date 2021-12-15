package com.example.anime_app.presenter.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anime_app.databinding.FragmentEpisodesBinding
import com.example.anime_app.presenter.view.recycler.EpisodesRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.EpisodesViewModel

class EpisodesFragment: Fragment()  {

    private lateinit var binding: FragmentEpisodesBinding
    private var animeId: Int = -1

    private lateinit var viewModel: EpisodesViewModel

    private lateinit var adapter: EpisodesRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: String)-> Unit = { x: String ->
            callbackFun(x)
        }
        adapter = EpisodesRecyclerAdapter(callbackFun)
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        parentFragmentManager.setFragmentResultListener(
            AnimeFragment.ANIME_ID_BUNDLE,
            viewLifecycleOwner,
            { _, result ->
                run {
                    animeId = result.getInt("anime_id")
                }
            })
        init()
    }

    override fun onResume() {
        super.onResume()
        refreshList(animeId)
    }

    fun callbackFun(url: String){
        val intent = Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent)
    }

    fun init(){
        binding.rvEpisodes.adapter = adapter
        initSub()

    }

    fun initSub(){
        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun refreshList(animeId: Int) {
        activity?.let { viewModel.updateList(animeId) }
    }

}