package com.example.youtubeclonee.model


import com.google.gson.annotations.SerializedName

data class HomeFeed(
    @SerializedName("videos")
    val videos: List<Video>
)