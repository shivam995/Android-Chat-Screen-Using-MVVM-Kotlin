package com.learnings.github.chatui.utils

import android.content.Context
import java.io.Serializable
import java.util.regex.Pattern

/**
 * Resource file for parsing image url from the config
 * Examples:-
 * "url":        "@IMAGE_LOCAL(chat_bg)"
 * "url":        "@IMAGE_REMOTE(http://www.sample.com/myimage.png)"
 */
object ImageResources {
    private const val REGEX_RESOURCE = "@([a-zA-Z_]+)\\((.+)\\)"
    const val SCHEME_IMAGE_REMOTE   = "IMAGE_REMOTE"
    const val SCHEME_IMAGE_LOCAL    = "IMAGE_LOCAL"
    const val SCHEME_VIDEO_REMOTE   = "VIDEO_REMOTE"
    const val SCHEME_AUDIO_LOCAL    = "AUDIO_LOCAL"

    fun parse(context: Context?, str: String?): ResourceData {
        if (null == context || null == str) {
            return ResourceData(null, null)
        }
        val matcher =
            Pattern.compile(REGEX_RESOURCE)
                .matcher(str)
        if (matcher.matches()) {
            val scheme = matcher.group(1)
            val resource = matcher.group(2)
            if (null != scheme && null != resource) {
                return ResourceData(scheme, resource)
            }
        }

        return ResourceData(null, null)
    }

}

data class ResourceData(
    val scheme: String?,
    val data: String?
) : Serializable