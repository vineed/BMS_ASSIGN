package com.bookmyshow.feature_one.di

import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import com.bookmyshow.feature_one.util.FeatureOneViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class FeatureOneModule {

    //Could be extracted as Interface to support unit testing (mock)
    @Provides
    fun getShowTimesRepository(networkProvider: NetworkProvider): ShowTimesRepository {
        return ShowTimesRepository(networkProvider)
    }

    @Provides
    fun getFeatureOneViewModelFactory(showTimesRepository: ShowTimesRepository): FeatureOneViewModelFactory {
        return FeatureOneViewModelFactory(showTimesRepository)
    }
}