package com.example.youtubeclonee.model


import com.google.gson.annotations.SerializedName

data class CourseDetailItem(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int
)