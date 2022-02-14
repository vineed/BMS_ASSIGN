package com.bookmyshow.feature_two.di

object FeatureTwoDaggerProvider {

    val component: FeatureTwoComponent by lazy {
        DaggerFeatureTwoComponent.factory().create()
    }
}