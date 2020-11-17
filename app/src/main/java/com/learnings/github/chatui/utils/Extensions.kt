package com.learnings.github.chatui.utils

import android.widget.ImageView


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