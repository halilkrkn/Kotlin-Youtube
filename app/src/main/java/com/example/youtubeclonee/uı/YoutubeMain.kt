package com.example.youtubeclonee.uı

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
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

       companion object{
           const val BASE_URL = "https://api.letsbuildthatapp.com/"
           private var feedHome: ArrayList<HomeFeed>? = null
       }


    val adapter =  GroupAdapter<GroupieViewHolder>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_main)


        recyclerViewMain.adapter = adapter
        recyclerViewMain.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        loadYoutubeData()

//       Dummy()



    }

    private fun loadYoutubeData(){


//
//
//        val client = OkHttpClient()
//
//        val retrofit = Retrofit.Builder()
//            .client(client)
//            .baseUrl("https://api.letsbuildthatapp.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(YoutubeApi::class.java)
//        val call = service.getData()
//
//
//        call.enqueue(object: Callback<HomeFeed>{
//            override fun onResponse(call: Call<HomeFeed>, response: Response<HomeFeed>) {
//                if (response.isSuccessful){
//
//                   val homeFeed = response.body()
//                        runOnUiThread {
//                            adapter.add(YoutubeMainRow(homeFeed))
//
//                        }
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<HomeFeed>, t: Throwable) {
//
//            }
//
//        })



       val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
       val request = Request.Builder()
           .url(url)
           .build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : okhttp3.Callback{
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                   e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread {

                    adapter.add(YoutubeMainRow(homeFeed))
                }
                adapter.setOnItemClickListener { item, view ->

                    val intent = Intent(view.context, CourseDetailActivity::class.java)
                    view.context.startActivity(intent)

                }
            }


        })
    }

//    private fun Dummy(){
//        adapter.add(YoutubeMainRow())
//        adapter.add(YoutubeMainRow())
//        adapter.add(YoutubeMainRow())
//        adapter.add(YoutubeMainRow())
//        adapter.add(YoutubeMainRow())
//    }
}