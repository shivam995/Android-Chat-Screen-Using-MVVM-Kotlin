package com.learnings.github.chatui.utils

import android.widget.ImageView
import java.util.regex.Matcher
import java.util.regex.Pattern


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