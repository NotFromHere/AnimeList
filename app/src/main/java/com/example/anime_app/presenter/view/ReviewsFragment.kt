package com.example.anime_app.presenter.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anime_app.databinding.FragmentReviewsBinding
import com.example.anime_app.presenter.view.recycler.PicturesRecyclerAdapter
import com.example.anime_app.presenter.view.recycler.ReviewsRecyclerAdapter
import com.example.anime_app.presenter.viewmodel.ReviewsModelView
import android.R
import android.app.AlertDialog

import android.widget.TextView
import android.content.DialogInterface
import android.text.Html


class ReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private var animeId: Int = -1

    private lateinit var viewModel: ReviewsModelView

    private lateinit var adapter: ReviewsRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val callbackFun: (x: String)-> Unit = { x: String ->
            callbackFun(x)
        }
        adapter = ReviewsRecyclerAdapter(callbackFun)
        binding = FragmentReviewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReviewsModelView::class.java)
        parentFragmentManager.setFragmentResultListener(
            AnimeFragment.ANIME_ID_BUNDLE_REVIEWS,
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

    fun callbackFun(review: String){
        AlertDialog.Builder(context)
            .setTitle("Review")
            .setMessage(Html.fromHtml("<font color='#FFFFFF'>${review}</font>"))
            .setPositiveButton(
                R.string.yes,
                DialogInterface.OnClickListener { dialog, which ->
                })
            .setNegativeButton(R.string.no, null)
            .show()
    }

    fun init(){
        binding.rvReviews.adapter = adapter
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