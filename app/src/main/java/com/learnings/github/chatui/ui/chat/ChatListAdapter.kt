package com.learnings.github.chatui.ui.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.InteractiveChat
import com.learnings.github.chatui.ui.chat.viewholder.ChatViewHolder
import com.learnings.github.chatui.utils.VIEW_TYPE_RECEIVED
import com.learnings.github.chatui.utils.VIEW_TYPE_SENT

class ChatListAdapter :
    ListAdapter<InteractiveChat, ChatViewHolder>(ChatDiffCallback())/* RecyclerView.Adapter<RecyclerView.ViewHolder>()*/ {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view: View
        return when (viewType) {
            VIEW_TYPE_RECEIVED -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.itemview_chat_received, parent, false)
                ChatViewHolder(view)
            }
            VIEW_TYPE_SENT -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.itemview_chat_sent, parent, false)
                ChatViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.itemview_chat_sent, parent, false)
                ChatViewHolder(view)
            }
        }
    }

    fun addItem(item: InteractiveChat) {
        var list = ArrayList<InteractiveChat>()
        list.addAll(currentList)
        list.add(item)
        submitList(list)
        notifyDataSetChanged()

    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type ?: VIEW_TYPE_SENT
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }


    private class ChatDiffCallback : DiffUtil.ItemCallback<InteractiveChat>() {

        override fun areItemsTheSame(oldItem: InteractiveChat, newItem: InteractiveChat): Boolean {
            return oldItem.createdAt == newItem.createdAt
        }

        override fun areContentsTheSame(
            oldItem: InteractiveChat,
            newItem: InteractiveChat
        ): Boolean {
            return oldItem == newItem
        }
    }

}