package com.learnings.github.chatui.ui.chat.viewholder

import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.MessageBody
import com.learnings.github.chatui.utils.ImageResources


class AudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivPlayPause = itemView.findViewById<ImageView>(R.id.ivPlayPause)
    private val context = itemView.context.applicationContext
    private var mMediaPlayer: MediaPlayer? = null

    fun bindData(data: MessageBody) {
        //TODO: not handling usecase for remote file as of now
        val resource = ImageResources.parse(itemView.context, data.url)
        val resID: Int = context.resources.getIdentifier(resource.data, "raw", context.packageName)
        mMediaPlayer = MediaPlayer.create(context, resID)

        mMediaPlayer?.setOnCompletionListener {
            stopPlaying()
        }

        ivPlayPause.setOnClickListener {
            if (it.tag == 1) {
                stopPlaying()
                it.tag = 0
            } else {
                startPlaying()
                it.tag = 1
            }
        }


    }

    private fun stopPlaying() {
        try {
            if (mMediaPlayer?.isPlaying == true) {
                mMediaPlayer?.pause()
            }
            ivPlayPause.setImageResource(android.R.drawable.ic_media_play)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    private fun startPlaying() {
        try {
            mMediaPlayer?.start()
            ivPlayPause.setImageResource(android.R.drawable.ic_media_pause)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }
}