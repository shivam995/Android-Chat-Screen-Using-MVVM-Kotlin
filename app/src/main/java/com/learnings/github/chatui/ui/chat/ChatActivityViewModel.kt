package com.learnings.github.chatui.ui.chat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.learnings.github.chatui.model.InteractiveChat
import com.learnings.github.chatui.repository.ChatRepository

class ChatActivityViewModel(application: Application) : AndroidViewModel(application) {

    private var chatRepository: ChatRepository = ChatRepository(application)
    var chatList: MutableLiveData<ArrayList<InteractiveChat>> =
        MutableLiveData<ArrayList<InteractiveChat>>().apply {
            this.postValue(chatRepository.loadChatLocally())
        }


}