package com.example.youtubeclonee.model


import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("name")
    val name: String,
    @SerializedName("numberOfSubscribers")
    val numberOfSubscribers: Int,
    @SerializedName("profileImageUrl")
    val profileImageUrl: String
)