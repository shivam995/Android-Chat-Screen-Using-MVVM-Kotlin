package com.learnings.github.chatui.utils

import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learnings.github.chatui.ui.chat.ChatActivityViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider() =
    ViewModelProvider(
        viewModelStore,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    )
        .get(VM::class.java)


fun ImageView.loadImage(resourceData: ResourceData?) {
    if (resourceData?.scheme == null || resourceData.data == null) {
        return
    }

    when (resourceData.scheme) {
        ImageResources.SCHEME_IMAGE_REMOTE -> {
            //TODO: add logic here
        }
        ImageResources.SCHEME_IMAGE_LOCAL -> {
            val image =
                context.resources.getIdentifier(resourceData.data, "drawable", context.packageName)
            this.setImageResource(image)
        }
    }
}

 fun String.extractYoutubeVideoId(): String? {
    val pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed/)[^#&?]*"
    val compiledPattern: Pattern = Pattern.compile(pattern)
    val matcher: Matcher = compiledPattern.matcher(this)
    return if (matcher.find()) {
        matcher.group()
    } else {
        ""
    }
}