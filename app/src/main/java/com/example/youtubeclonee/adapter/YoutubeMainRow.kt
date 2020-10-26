package com.example.youtubeclonee.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclonee.R
import com.example.youtubeclonee.model.HomeFeed
import com.example.youtubeclonee.model.Video
import com.example.youtubeclonee.uı.CourseDetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.youtube_main_row.view.*


class YoutubeMainRow(private val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>(){
    override fun getItemCount(): Int {

        return homeFeed?.videos.count()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.youtube_main_row, parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = homeFeed?.videos?.get(position)
        holder.itemView.textView_youtube_main.text = video?.name
        holder.itemView.textViewYoutubeChannelName.text = video?.channel?.name  + "    .     " + "28K Views\n 4 day ago"
        Picasso.get().load(video?.channel?.profileImageUrl).into(holder.itemView.imageViewProfilPhoto)
        Picasso.get().load(video?.imageUrl).into(holder.itemView.imageViewVideo)

        holder.video = video
    }
    
}

class CustomViewHolder(view: View, var video: Video? = null): RecyclerView.ViewHolder(view){

    companion object{
        const val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        const val VIDEO_ID_KEY = "VIDEO_ID"
    }init {

        view.setOnClickListener {


            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY,video?.id)
            view.context.startActivity(intent)

        }
    }
    
}


