package com.bookmyshow.feature_two.di

import com.bookmyshow.feature_two.FeatureTwoActivity
import dagger.Component

@Component
interface FeatureTwoComponent {

    @Component.Factory
    interface Factory {
        fun create(): FeatureTwoComponent
    }

    fun inject(activity: FeatureTwoActivity)
}