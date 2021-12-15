package com.example.anime_app.presenter.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.anime_app.databinding.FragmentVideosBinding
import com.example.anime_app.presenter.view.recycler.VideosRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.VideosViewModel

class VideosFragment : Fragment() {

    private lateinit var binding: FragmentVideosBinding
    private var animeId: Int = -1

    private lateinit var viewModel: VideosViewModel

    private lateinit var adapter: VideosRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: String)-> Unit = { x: String ->
            callbackFun(x)
        }
        adapter = VideosRecyclerAdapter(callbackFun)
        binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideosViewModel::class.java)
        parentFragmentManager.setFragmentResultListener(
            AnimeFragment.ANIME_ID_BUNDLE_VIDEOS,
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
        Intent(this.context, YouTubeActivity::class.java).let {
            it.putExtra("video_id", url)
            this.startActivity(it)
        }
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