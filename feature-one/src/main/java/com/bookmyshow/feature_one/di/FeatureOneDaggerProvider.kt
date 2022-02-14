package com.bookmyshow.feature_one.di

import com.bookmyshow.common_ui.di.CommonDaggerProvider

object FeatureOneDaggerProvider {

    val component: FeatureOneComponent by lazy {
        DaggerFeatureOneComponent.factory().create(
            commonComponent = CommonDaggerProvider.component
        )
    }
}