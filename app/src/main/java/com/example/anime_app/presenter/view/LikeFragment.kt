package com.example.anime_app.presenter.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anime_app.databinding.FragmentLikeBinding
import com.example.anime_app.presenter.view.recycler.AnimeLikeRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.LikeAnimeViewModel

class LikeFragment : Fragment() {

    private lateinit var binding: FragmentLikeBinding

    private lateinit var viewModel: LikeAnimeViewModel

    private lateinit var adapter: AnimeLikeRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: Int)-> Unit = { x: Int ->
            callbackFun(container, x)
        }
        adapter = AnimeLikeRecyclerAdapter(callbackFun)
        binding = FragmentLikeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    fun callbackFun(container: ViewGroup?, x: Int){
/*        if (container != null) {
            val animeFragment = AnimeFragment()
            parentFragmentManager.setFragmentResult(MainFragment.ANIME_ID_BUNDLE, bundleOf(Pair("anime_id", x)))
            parentFragmentManager.beginTransaction()
                .replace(container.id, animeFragment)
                .addToBackStack(null)
                .commit()
        }*/
    }

    fun init(){
        binding.rvAnimeLike.adapter = adapter
        viewModel = ViewModelProvider(this).get(LikeAnimeViewModel::class.java)
        initSub()

    }

    fun initSub(){
        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun refreshList() {
        activity?.let { viewModel.updateList(it.applicationContext) }
        viewModel.list.value?.forEach {
            Log.d("list123123", it.name)
        }
    }

}