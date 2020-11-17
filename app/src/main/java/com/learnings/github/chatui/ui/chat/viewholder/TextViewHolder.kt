package com.learnings.github.chatui.ui.chat.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.MessageBody

class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvMessage = view.findViewById<TextView>(R.id.message)

    fun bindData(data: MessageBody) {
        tvMessage.text = data.message
    }
}