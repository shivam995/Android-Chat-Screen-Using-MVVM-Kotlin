package com.learnings.github.chatui.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.learnings.github.chatui.R
import com.learnings.github.chatui.ui.chat.ChatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            //start main activity
            startActivity(Intent(this@SplashActivity,
                ChatActivity::class.java))
            finish()
        },3000)
    }
}