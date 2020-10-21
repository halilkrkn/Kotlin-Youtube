package com.example.youtubeclonee.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclonee.R
import com.example.youtubeclonee.model.HomeFeed
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.youtube_main_row.view.*
import retrofit2.Response

class YoutubeMainRow(val homeFeed: HomeFeed?): Item<GroupieViewHolder>() {


    override fun getLayout(): Int {
        return R.layout.youtube_main_row
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val video = homeFeed?.videos?.get(position)
        viewHolder.itemView.textView_youtube_main.text = video?.name
        viewHolder.itemView.textViewYoutubeChannelName.text = video?.channel?.name  + "    .     " + "28K Views\n 4 day ago"
        Picasso.get().load(video?.channel?.profileImageUrl).into(viewHolder.itemView.imageViewProfilPhoto)
    }
}