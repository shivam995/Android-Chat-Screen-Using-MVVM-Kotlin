package com.learnings.github.chatui.ui.chat.viewholder

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.InteractiveChat
import com.learnings.github.chatui.model.MessageBody
import com.learnings.github.chatui.utils.*
import java.text.SimpleDateFormat
import java.util.*

class ChatViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val frameContainer: FrameLayout = itemView.findViewById(R.id.frameBody)
    private val tvCreationTime: TextView = itemView.findViewById(R.id.tvCreationTime)
    private val inflater: LayoutInflater = LayoutInflater.from(view.context)
    private val dateFormat = SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.getDefault())

    fun bindData(data: InteractiveChat) {
        val messageBody = data.messageBody as MessageBody

        val subView: View
        when (messageBody.messageType) {
            VIEW_TYPE_TEXT -> {
                subView = inflater.inflate(R.layout.itemview_text_chat_viewholder, null)
                TextViewHolder(subView).bindData(messageBody)
                frameContainer.addView(subView)
            }
            VIEW_TYPE_IMAGE -> {
                subView = inflater.inflate(R.layout.itemview_image_chat_viewholder, null)
                ImageViewHolder(subView).bindData(messageBody)
                frameContainer.addView(subView)
            }
            VIEW_TYPE_AUDIO -> {
                subView = inflater.inflate(R.layout.itemview_audio_chat_viewholder, null)
                AudioViewHolder(subView).bindData(messageBody)
                frameContainer.addView(subView)
            }
            VIEW_TYPE_VIDEO -> {
                subView = inflater.inflate(R.layout.itemview_video_chat_viewholder, null)
                VideoViewHolder(subView).bindData(messageBody)
                frameContainer.addView(subView)
            }
        }
    }
}