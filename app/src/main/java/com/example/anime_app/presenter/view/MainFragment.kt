package com.example.anime_app.presenter.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.example.anime_app.R
import com.example.anime_app.databinding.FragmentMainBinding
import com.example.anime_app.presenter.view.recycler.AnimeRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
        const val ANIME_ID_BUNDLE: String = "anime_id_bundle"
    }

    private lateinit var adapter: AnimeRecyclerAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: Int)-> Unit = { x: Int ->
            callbackFun(container, x)
        }
        adapter = AnimeRecyclerAdapter(callbackFun)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE
    }

    private fun callbackFun(container: ViewGroup?, x: Int) {
        if (container != null) {
            val animeFragment = AnimeFragment()
            parentFragmentManager.setFragmentResult(ANIME_ID_BUNDLE, bundleOf(Pair("anime_id", x)))
            parentFragmentManager.beginTransaction()
                .replace(container.id, animeFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        initListeners()
    }

    private fun initListeners() {
        binding.searchMain.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.getByName(query)
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        firstInitList()
        initSub()
    }

    private fun initSub() {
        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.listByName.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun firstInitList() {
        binding.rvMain.adapter = adapter
        viewModel.updateList()
    }

}