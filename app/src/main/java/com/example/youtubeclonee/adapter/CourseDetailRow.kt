package com.example.youtubeclonee.adapter

import com.example.youtubeclonee.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.course_detail_row.view.*

class CourseDetailRow: Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.textView_course_detail_lesson_title.text = "Course Lesson Title"


    }

    override fun getLayout(): Int {
        return R.layout.course_detail_row
    }
}