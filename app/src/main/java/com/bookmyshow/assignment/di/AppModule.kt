package com.bookmyshow.assignment.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Akshansh Dhing on 14/02/22.
 */
@Module
class AppModule(
    private val application: Application
) {

    @Provides
    fun getContext(): Context = application.applicationContext
}