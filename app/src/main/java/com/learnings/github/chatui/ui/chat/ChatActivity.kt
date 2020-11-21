package com.learnings.github.chatui.ui.chat

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.learnings.github.chatui.databinding.ActivityChatBinding
import com.learnings.github.chatui.model.InteractiveChat
import com.learnings.github.chatui.utils.VIEW_TYPE_SENT
import com.learnings.github.chatui.utils.viewModelProvider
import kotlinx.android.synthetic.main.activity_chat.*


class ChatActivity : AppCompatActivity() {
    private val TAG = ChatActivity::class.java.simpleName
    private lateinit var viewModel: ChatActivityViewModel
    private lateinit var chatListAdapter: ChatListAdapter
    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModel = viewModelProvider()
        addViewModelObserver()
    }

    private fun initAdapter() {
        chatListAdapter = ChatListAdapter()
        rvChatList.adapter = chatListAdapter

        rvChatList.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    rvChatList.viewTreeObserver.removeOnPreDrawListener(this)
                    for (i in 0 until rvChatList.childCount) {
                        val isMessageTypeSent =
                            chatListAdapter.currentList[i].type == VIEW_TYPE_SENT
                        val v: View = rvChatList.getChildAt(i)
                        v.translationX = if (isMessageTypeSent) 1000f else -1000f

                        v.animate().also {
                            it.translationX(0f)
                            it.duration = 300
                            it.startDelay = i * 2000L
                            it.interpolator = AccelerateInterpolator()
                        }.start()
                    }
                    return true
                }
            })

    }

    private fun addViewModelObserver() {
        viewModel.chatList.observe(this, Observer<List<InteractiveChat>> { list ->
            if (!list.isNullOrEmpty()) {
                chatListAdapter.submitList(list)
                chatListAdapter.notifyDataSetChanged()
            }
        })
    }
}