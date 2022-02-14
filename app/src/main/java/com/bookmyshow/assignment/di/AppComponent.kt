package com.bookmyshow.assignment.di

import com.bookmyshow.common_ui.di.CommonModule
import com.bookmyshow.feature_one.di.FeatureOneComponent
import com.bookmyshow.feature_two.di.FeatureTwoComponent
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        CommonModule::class
    ],
    dependencies = [
        FeatureOneComponent::class,
        FeatureTwoComponent::class,
    ]
)
interface AppComponent