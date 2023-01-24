package com.bookmyshow.feature_one.venue.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.repository.Result
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class FeatureOneViewModel @Inject constructor(val showTimesRepository: ShowTimesRepository) :
    ViewModel() {

    private val _venuesData = MutableLiveData<List<Venue>>()
    val venuesData: LiveData<List<Venue>> = _venuesData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        viewModelScope.launch {
            val result = showTimesRepository.getAllVenues()
            Log.d("init: ", "init: ")
            when (result) {
                is Result.Success -> {
                    val data = result.data

                    _venuesData.value = data
                }
                is Result.Failure -> {
                    _error.value = result.message
                }
                is Result.Exception -> {
                    result.throwable.printStackTrace()
                }
            }
        }
    }
}