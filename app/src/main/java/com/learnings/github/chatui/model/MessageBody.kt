package com.learnings.github.chatui.model

data class MessageBody(
    val messageType: Int?,
    val message: String?,
    val url: String?,
    val id: Long = System.currentTimeMillis()
)