package com.example.youtubeclonee.uı

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeclonee.R
import com.example.youtubeclonee.adapter.YoutubeMainRow
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_youtube_main.*

class YoutubeMain : AppCompatActivity() {

    val adapter =  GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_main)


        recyclerViewMain.adapter = adapter
        Dummy()



    }


    private fun Dummy(){
        adapter.add(YoutubeMainRow())
        adapter.add(YoutubeMainRow())
        adapter.add(YoutubeMainRow())
        adapter.add(YoutubeMainRow())
        adapter.add(YoutubeMainRow())
    }
}