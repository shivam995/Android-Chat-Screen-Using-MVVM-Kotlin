package com.learnings.github.chatui.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.learnings.github.chatui.model.InteractiveChat
import kotlinx.coroutines.coroutineScope

class ChatRepository constructor(private val applicationContext: Context) {

      fun  loadChatLocally() : ArrayList<InteractiveChat> {
         var dataList = ArrayList<InteractiveChat>()
            try {
                applicationContext.assets.open("chat_data.json").use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val plantType = object : TypeToken<ArrayList<InteractiveChat>>() {}.type
                        dataList = Gson().fromJson(jsonReader, plantType)
                    }
                }
            } catch (ex: Exception) {
                Log.e("ChatRepository", "Error fetching chat locally", ex)
            }
        return dataList
    }
}