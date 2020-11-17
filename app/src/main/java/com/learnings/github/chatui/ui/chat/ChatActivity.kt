package com.learnings.github.chatui.ui.chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnings.github.chatui.R
import com.learnings.github.chatui.model.InteractiveChat
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
        /* val handler = Handler(Looper.getMainLooper())
         rvChatList.viewTreeObserver.addOnPreDrawListener(
             object : ViewTreeObserver.OnPreDrawListener {
                 override fun onPreDraw(): Boolean {
                     rvChatList.viewTreeObserver.removeOnPreDrawListener(this)
                     for (i in 0 until rvChatList.childCount) {
                         handler.postDelayed(Runnable {
                             val v: View = rvChatList.getChildAt(i)
                             v.alpha = 0.0f
                             v.animate().alpha(1.0f)
                                 .setDuration(700)
                                 .setStartDelay(50L)
                                 .start()
                         },2000)
                     }
                     return true
                 }
             })*/

    }

    private fun addViewModelObserver() {
        viewModel?.chatList?.observe(this, Observer<List<InteractiveChat>> { list ->
            if (!list.isNullOrEmpty()) {
                Log.e(TAG, "newList size: ${list.count()}")
                chatListAdapter.submitList(list)
                chatListAdapter.notifyDataSetChanged()
            }
        })
    }
}