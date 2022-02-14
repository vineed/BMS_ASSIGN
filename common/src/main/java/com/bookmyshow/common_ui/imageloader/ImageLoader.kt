package com.bookmyshow.common_ui.imageloader

import android.widget.ImageView

interface ImageLoader {

    fun cacheImage(
        imageUrl: String
    )

    fun loadImage(
        imageUrl: String,
        imageView: ImageView
    )
}