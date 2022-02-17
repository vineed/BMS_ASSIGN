package com.bookmyshow.assignment

import android.app.Application
import com.bookmyshow.assignment.di.AppComponent
import com.bookmyshow.assignment.di.DaggerAppComponent

class AssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
    }
}