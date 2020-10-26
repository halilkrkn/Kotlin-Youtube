package com.example.youtubeclonee.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclonee.R
import com.example.youtubeclonee.model.CourseDetail
import com.example.youtubeclonee.model.CourseDetailItem
import com.example.youtubeclonee.model.Video
import com.example.youtubeclonee.uı.CourseDetailActivity
import com.example.youtubeclonee.uı.CourseLessonActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.course_detail_row.view.*
import kotlinx.android.synthetic.main.youtube_main_row.view.*

class CourseDetailRow(val courseLessons: CourseDetail): RecyclerView.Adapter<CourseDetailViewHolder>(){

    // Ne kadar veri var hepsini çektik.
    override fun getItemCount(): Int {
        return courseLessons.size
    }

    // Oluşturduğumuz   course_detail_row activitesini tanımladık ki recycler view de daha sadece düzenli gözükmesi için
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val courseRow = layoutInflater.inflate(R.layout.course_detail_row,parent,false)
        return CourseDetailViewHolder(courseRow)
    }

    // course_detail_row da oluşturduğumuz imageview ve textviewları api deki verilerle eşleştirdim ve view de gözükmesini sağladım.
    override fun onBindViewHolder(holder: CourseDetailViewHolder, position: Int) {
        val courseLesson = courseLessons.get(position)
         holder.customView.textView_course_detail_lesson_title.text = courseLesson.name
         holder.customView.textView_duration.text = courseLesson.duration

        val imageView = holder.customView.imageView_course_detail
        Picasso.get().load(courseLesson.imageUrl).into(imageView)

        holder.courseLesson = courseLesson
    }




}

class CourseDetailViewHolder(val customView: View, var courseLesson: CourseDetailItem? = null): RecyclerView.ViewHolder(customView){

    companion object{
        val COURSE_LINK_KEY = "COURSE_LESSON_LINK"
    }
    init {
        // CourseLessonActivity e yönlendirdik ve intent yardımıyla da gerekli kısımları da api den çekmiş olup view da gösterdik.
        customView.setOnClickListener {
            
            val intent = Intent(customView.context, CourseLessonActivity::class.java)
            intent.putExtra(COURSE_LINK_KEY,courseLesson?.link)
            customView.context.startActivity(intent)

        }
    }



    


}