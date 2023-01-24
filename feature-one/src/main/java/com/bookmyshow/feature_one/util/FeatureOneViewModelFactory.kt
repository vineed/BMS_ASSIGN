package com.bookmyshow.feature_one.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import com.bookmyshow.feature_one.venue.viewmodel.FeatureOneViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class FeatureOneViewModelFactory @Inject constructor(val showTimesRepository: ShowTimesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        return FeatureOneViewModel(showTimesRepository) as T/*when(modelClass) {
            FeatureOneViewModel::javaClass -> {
               FeatureOneViewModel(showTimesRepository) as T
            }
            else -> throw java.lang.IllegalArgumentException("ViewModel: $modelClass, not supported!!!")
        }*/
    }
}