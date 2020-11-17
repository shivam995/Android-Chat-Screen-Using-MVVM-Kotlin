package com.learnings.github.chatui.ui.chat.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.MessageBody
import com.learnings.github.chatui.ui.dialog.ImageFullscreenActivity
import com.learnings.github.chatui.utils.ImageResources
import com.learnings.github.chatui.utils.loadImage


class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

    fun bindData(data: MessageBody) {
        val resData = ImageResources.parse(itemView.context, data.url)
        imageView.loadImage(resData)

        itemView.setOnClickListener {
            val intent = ImageFullscreenActivity.createIntent(itemView.context, resData)
            itemView.context.startActivity(intent)
        }
    }
}