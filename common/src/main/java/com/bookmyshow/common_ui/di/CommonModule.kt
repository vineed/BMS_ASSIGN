package com.bookmyshow.common_ui.di

import android.app.Application
import android.content.Context
import com.bookmyshow.common_ui.imageloader.ImageLoader
import com.bookmyshow.common_ui.imageloader.ImageLoaderImpl
import dagger.Module
import dagger.Provides

@Module
class CommonModule(
    private val application: Application
) {

    @Provides
    fun getApplication() = application

    @Provides
    fun getContext() = application.applicationContext

    @Provides
    fun getImageLoader(
        context: Context
    ): ImageLoader {
        return ImageLoaderImpl(
            context = context
        )
    }
}