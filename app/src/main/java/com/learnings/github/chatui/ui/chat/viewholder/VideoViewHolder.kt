package com.learnings.github.chatui.ui.chat.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.chatui.model.MessageBody
import com.learnings.github.chatui.utils.ImageResources


class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view)
    /*YouTubeThumbnailView.OnInitializedListener*/ {
//    private val UNINITIALIZED = 1
//    private val INITIALIZING = 2
//    private val INITIALIZED = 3


//    private val videoView = itemView.findViewById<YouTubeThumbnailView>(R.id.videoView)
//    private val ivThumbnail = itemView.findViewById<ImageView>(R.id.ivThumbnail)
//    private var videoId: String? = ""

    /*private fun initYtView(){
        videoView.setTag(R.id.initialize, INITIALIZING)
        videoView.setTag(R.id.thumbnailloader, null)
        videoView.setTag(R.id.videoid, videoId)
        videoView.initialize(BuildConfig.API_KEY, this)
    }*/

    fun bindData(data: MessageBody) {
        val resourceData = ImageResources.parse(itemView.context, data.url)
       /* videoId = resourceData.data?.extractYoutubeVideoId()
        //TODO: NOT handling case for loading LOCAL_VIDEO for now

        val state = videoView.getTag(R.id.initialize)
        if (state == UNINITIALIZED) {
            initYtView()
        } else if (state == INITIALIZED) {
            val loader = videoView.getTag(R.id.thumbnailloader) as YouTubeThumbnailLoader
            loader.setVideo(videoId)
        }*/

        itemView.setOnClickListener {

        }

    }
/*
    override fun onInitializationSuccess(
        thumbnailView: YouTubeThumbnailView?,
        thumbnailLoader: YouTubeThumbnailLoader?
    ) {
        videoView?.setTag(R.id.initialize, INITIALIZED)
        videoView?.setTag(R.id.thumbnailloader, thumbnailLoader)
//        videoView?.setTag(R.id.videoid, videoId)

        thumbnailLoader?.setOnThumbnailLoadedListener(object :
            YouTubeThumbnailLoader.OnThumbnailLoadedListener {
            override fun onThumbnailLoaded(thumbnailView: YouTubeThumbnailView?, id: String?) {
                videoId = id
            }

            override fun onThumbnailError(
                p0: YouTubeThumbnailView?,
                p1: YouTubeThumbnailLoader.ErrorReason?
            ) {
                Log.e("Error",Gson().toJson(p1))
            }
        })

        val videoId = videoView.getTag(R.id.videoid) as String?
        if (videoId != null && videoId.isNotEmpty()) {
            thumbnailLoader?.setVideo(videoId)
        }
    }

    override fun onInitializationFailure(
        p0: YouTubeThumbnailView?,
        p1: YouTubeInitializationResult?
    ) {
        p0?.setTag(R.id.initialize, UNINITIALIZED)
        Log.e("Error",Gson().toJson(p1))
    }*/
}