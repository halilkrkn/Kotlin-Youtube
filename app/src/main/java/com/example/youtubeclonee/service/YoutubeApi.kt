package com.example.youtubeclonee.service

import com.example.youtubeclonee.model.HomeFeed
import com.example.youtubeclonee.model.Video
import retrofit2.Call
import retrofit2.http.GET

interface YoutubeApi {


    @GET("/youtube/home_feed")
    fun getData(): Call<HomeFeed>
}