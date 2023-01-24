package com.bookmyshow.feature_one.model

import java.util.*

data class Venue(
    val name: String,
    val showDate: Date,
    val showDisplayDate: String? = "--:--",
    val showtimes: List<ShowTime>? = emptyList(),
)