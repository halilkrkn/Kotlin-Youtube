package com.example.youtubeclonee.uı

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeclonee.R
import com.example.youtubeclonee.adapter.CourseDetailRow
import com.example.youtubeclonee.adapter.CustomViewHolder.Companion.VIDEO_ID_KEY
import com.example.youtubeclonee.adapter.CustomViewHolder.Companion.VIDEO_TITLE_KEY
import com.example.youtubeclonee.model.CourseDetail
import com.example.youtubeclonee.model.CourseDetailItem
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_course_detail.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity : AppCompatActivity() {


    // var toVideoId : Video? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        //recyclerViewMain.setBackgroundColor(Color.RED)


        recyclerview_course_detail.layoutManager = LinearLayoutManager(this)

        val navBarTitle = intent.getStringExtra(VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle
        fetchJson()

//      Dummy()


    }

    private fun fetchJson() {
        val videoId = intent.getIntExtra(VIDEO_ID_KEY, -1)
        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId


        val request = Request.Builder()
            .url(courseDetailUrl)
            .build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val courseLessons = gson.fromJson(body, CourseDetail::class.java)

                runOnUiThread {
                    recyclerview_course_detail.adapter = CourseDetailRow(courseLessons)
                }
            }

        })
    }
}