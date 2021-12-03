package com.example.anime_app.presenter.view

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.opengl.Visibility
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Environment
import android.text.format.Time
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.Observer
import com.example.anime_app.R
import com.example.anime_app.databinding.FragmentAnimeBinding
import com.example.anime_app.presenter.viewmodel.AnimeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*
import java.util.*

class AnimeFragment : Fragment() {

    private lateinit var binding: FragmentAnimeBinding
    private var animeId: Int = -1

    companion object {
        fun newInstance() = AnimeFragment()
    }

    private lateinit var viewModel: AnimeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimeViewModel::class.java)
        parentFragmentManager.setFragmentResultListener(
            MainFragment.ANIME_ID_BUNDLE,
            viewLifecycleOwner,
            { _, result ->
                run {
                    animeId = result.getInt("anime_id")
                    init(animeId)
                }
            })
    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
    }

    private fun init(anime_id: Int) {
        initSub()
        CoroutineScope(Dispatchers.IO).launch {
           initListeners()
        }
        viewModel.updateAnimeInfo(anime_id)
    }

    private fun initSub() {
        viewModel.title.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeTitle.text = it
        })
        viewModel.score.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeScoreValue.text = it
        })
        viewModel.rank.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeRankValue.text = it
        })
        viewModel.popularity.observe(viewLifecycleOwner, Observer {
            binding.tvAnimePopularityValue.text = it
        })
        viewModel.members.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeMembersValue.text = it
        })
        viewModel.favorites.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeFavoritesValue.text = it
        })
        viewModel.synopsis.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeSynopsis.text = it
        })
        viewModel.type.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeType.text = it
        })
        viewModel.status.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeStatus.text = it
        })
        viewModel.episodes.observe(viewLifecycleOwner, Observer {
            binding.tvAnimeEpisodes.text = it
        })
        viewModel.genres.observe(viewLifecycleOwner, Observer {
            it.forEach {
                val tv = TextView(this.context)
                tv.run {
                    setText(it)
                    setTextSize(12F)
                    setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                    width = 200
                }
                binding.containerAnimeGenre.addView(tv)
            }
        })
        viewModel.imageUrl.observe(viewLifecycleOwner, Observer {
            Picasso.get()
                .load(it)
                .placeholder(R.drawable.anime_list_logo)
                .error(R.drawable.ic_home_black_24dp)
                .fit()
                .into(binding.imageViewAnimePoster)
        })
    }

    private fun initListeners(){
        binding.btAddLike.setOnClickListener{
            if(checkSelfPermission()) {
                val uri: String = downloadImage()
                activity?.let { activity ->
                    viewModel.saveAnimeLike(
                        activity.applicationContext,
                        animeId,
                        binding.tvAnimeTitle.text.toString(),
                        uri
                    )
                }
            } else {
                Toast.makeText(activity, "No access to internal storage", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun downloadImage(): String {
        val imgView: ImageView =  binding.imageViewAnimePoster
        var dir = activity?.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        val file: File = File(dir, Random().nextInt(1000).toString() + ".jpg")
        try {
            val out = FileOutputStream(file)
            val bitmap: Bitmap = imgView.drawable.toBitmap()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, out)
            out.flush()
            out.close()
        } catch (e: Exception){
            e.printStackTrace()
        }
        return file.path
    }

    private fun checkSelfPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity?.let {
                    ContextCompat.checkSelfPermission(
                        it,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                }
                == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                activity?.let {
                    ActivityCompat.requestPermissions(
                        it,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        1
                    )
                };
                return false;
            }
        } else {
            return true;
        }
    }
}