package com.example.youtubeclonee.uı

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclonee.R
import com.example.youtubeclonee.adapter.CourseDetailRow
import com.example.youtubeclonee.adapter.YoutubeMainRow
import com.example.youtubeclonee.model.Channel
import com.example.youtubeclonee.model.HomeFeed
import com.example.youtubeclonee.model.Video
import com.example.youtubeclonee.service.YoutubeApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_youtube_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class YoutubeMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_main)


        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        loadYoutubeData()

//       Dummy()



    }

   // OkHttp yi kullnarak veriyi çektim.
    private fun loadYoutubeData(){

       // Api uzantımız
       val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

       //Api uzantımız için isteğimizi oluşturduk.
       val request = Request.Builder()
           .url(url)
           .build()

       // okHttpClient ıda kullanarak verilerin  çekmemizi sağladım.
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val body = response.body?.string()

                //Gson ile verilerin Json formatında çekmemize sağlıyor.
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                //Thread de hatta çıkmasın diye bu blog içerinse tanımladık.
                runOnUiThread {

                    recyclerViewMain.adapter = YoutubeMainRow(homeFeed)

                }
            }
        })
    }
}