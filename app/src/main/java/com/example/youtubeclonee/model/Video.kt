package com.example.youtubeclonee.model


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("channel")
    val channel: Channel,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("numberOfViews")
    val numberOfViews: Int
)