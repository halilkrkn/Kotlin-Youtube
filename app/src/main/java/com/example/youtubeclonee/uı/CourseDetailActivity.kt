package com.example.youtubeclonee.uı

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeclonee.R
import com.example.youtubeclonee.adapter.CourseDetailRow
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.activity_youtube_main.*

class CourseDetailActivity : AppCompatActivity() {

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        //recyclerViewMain.setBackgroundColor(Color.RED)


        recyclerview_course_detail.adapter = adapter

        Dummy()


    }

    private fun Dummy(){


        adapter.add(CourseDetailRow())
        adapter.add(CourseDetailRow())
        adapter.add(CourseDetailRow())



    }                                 
}