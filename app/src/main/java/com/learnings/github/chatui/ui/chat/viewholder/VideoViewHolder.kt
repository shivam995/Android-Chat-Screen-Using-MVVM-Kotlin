package com.learnings.github.chatui.ui.chat.viewholder

import android.view.View
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.MessageBody
import com.learnings.github.chatui.utils.ImageResources

class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val videoView = itemView.findViewById<VideoView>(R.id.videoView)

    fun bindData(data: MessageBody) {
        val resourceData = ImageResources.parse(itemView.context, data.url)
        //TODO: NOT handling case for loading LOCAL_VIDEO for now

//        videoView.setVideoPath(resourceData?.data)
//        videoView.seekTo(1)

        itemView.setOnClickListener {

        }

    }
}