package com.example.anime_app.presenter.view

import android.os.Bundle
import android.widget.Toast
import com.example.anime_app.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class YouTubeActivity: YouTubeBaseActivity(),
YouTubePlayer.OnInitializedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        val youTubeView: YouTubePlayerView = findViewById(R.id.youtube_view);
        youTubeView.initialize("AIzaSyBd2Sj5eeAy-ORq7MLznwQQxIGiSMwaFj4", this);

    }


    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (p1 != null) {

            p1.loadVideo(intent.getStringExtra("video_id"))
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
    }


}