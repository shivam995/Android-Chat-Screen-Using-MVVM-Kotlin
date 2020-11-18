package com.learnings.github.chatui.ui.chat

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.InteractiveChat
import com.learnings.github.chatui.utils.VIEW_TYPE_SENT
import kotlinx.android.synthetic.main.activity_main.*


class ChatActivity : AppCompatActivity() {
    private val TAG = ChatActivity::class.java.simpleName
    private var viewModel: ChatActivityViewModel? = null
    private lateinit var chatListAdapter: ChatListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        viewModel = ViewModelProvider(
            viewModelStore,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
            .get(ChatActivityViewModel::class.java)
        addViewModelObserver()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.stackFromEnd = true
        rvChatList.layoutManager = layoutManager
        chatListAdapter = ChatListAdapter()
        rvChatList.adapter = chatListAdapter

        rvChatList.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    rvChatList.viewTreeObserver.removeOnPreDrawListener(this)
                    for (i in 0 until rvChatList.childCount) {
                        val isMessageTypeSent = chatListAdapter.currentList[i].type == VIEW_TYPE_SENT

                        val v: View = rvChatList.getChildAt(i)
                        v.translationX = if(isMessageTypeSent)  1000f else -1000f

                        v.animate().also {
                            it.translationX(0f)
                            it.duration = 400
                            it.startDelay = i*2000L
                            it.interpolator = AccelerateInterpolator()
                        }.start()
                    }
                    return true
                }
            })

    }

    private fun addViewModelObserver() {
        viewModel?.chatList?.observe(this, Observer<List<InteractiveChat>> { list ->
            if (!list.isNullOrEmpty()) {
                chatListAdapter.submitList(list)
                chatListAdapter.notifyDataSetChanged()

            }
        })
    }
}