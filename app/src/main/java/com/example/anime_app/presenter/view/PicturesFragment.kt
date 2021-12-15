package com.example.anime_app.presenter.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_app.databinding.FragmentPicturesBinding
import com.example.anime_app.databinding.FragmentReviewsBinding
import com.example.anime_app.presenter.view.recycler.PicturesRecyclerAdapter
import com.example.anime_app.presenter.view.recycler.ReviewsRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.PicturesViewModel
import com.example.anime_app.presenter.viewmodel.ReviewsModelView

class PicturesFragment : Fragment() {

    private lateinit var binding: FragmentPicturesBinding
    private var animeId: Int = -1

    private lateinit var viewModel: PicturesViewModel

    private lateinit var adapter: PicturesRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: String)-> Unit = { x: String ->
            callbackFun(x)
        }
        adapter = PicturesRecyclerAdapter(callbackFun)
        binding = FragmentPicturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PicturesViewModel::class.java)
        parentFragmentManager.setFragmentResultListener(
            AnimeFragment.ANIME_ID_BUNDLE_PICTURES,
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
        //todo
    }

    fun init(){
        binding.rvPictures.layoutManager = GridLayoutManager(this.context, 2)
        binding.rvPictures.adapter = adapter
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