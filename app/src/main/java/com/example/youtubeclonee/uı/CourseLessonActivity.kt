package com.example.youtubeclonee.uı

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeclonee.R
import com.example.youtubeclonee.adapter.CourseDetailRow
import com.example.youtubeclonee.adapter.CourseDetailViewHolder
import com.example.youtubeclonee.adapter.CustomViewHolder
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)

//        webView_course_lesson.setBackgroundColor(Color.YELLOW)
        

        val courseLink =  intent.getStringExtra(CourseDetailViewHolder.COURSE_LINK_KEY)

        // WebView İçin gerekli izinleri setting kısmından ayarladık.
        webView_course_lesson.settings.javaScriptEnabled = true
        webView_course_lesson.settings.loadWithOverviewMode = true
        webView_course_lesson.settings.useWideViewPort = true
        webView_course_lesson.loadUrl(courseLink)
    }
}