package com.bookmyshow.feature_one.model

import com.bookmyshow.core.model.ShowTimeDTO
import com.bookmyshow.feature_one.util.Utility
import java.time.LocalTime
import java.util.*

data class ShowTime(
    val hour: Int? = -1,
    val min: Int? = -1,
    val displayStr: String? = ""
)