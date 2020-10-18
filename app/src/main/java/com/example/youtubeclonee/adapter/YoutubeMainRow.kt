package com.example.youtubeclonee.adapter

import com.example.youtubeclonee.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.youtube_main_row.view.*

class YoutubeMainRow: Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.youtube_main_row
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
       viewHolder.itemView.textView_youtube_main.text = "2323231"
    }
}