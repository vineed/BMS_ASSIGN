package com.bookmyshow.assignment

import android.app.Application
import com.bookmyshow.assignment.di.AppModule
import com.bookmyshow.assignment.di.DaggerAppComponent
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_two.di.FeatureTwoDaggerProvider

class AssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule(application = this))
            .featureOneComponent(FeatureOneDaggerProvider.component)
            .featureTwoComponent(FeatureTwoDaggerProvider.component)
            .build()
    }
}