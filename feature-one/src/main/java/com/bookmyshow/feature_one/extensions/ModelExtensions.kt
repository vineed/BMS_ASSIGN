package com.bookmyshow.feature_one.extensions

import com.bookmyshow.core.model.ShowTimeDTO
import com.bookmyshow.core.model.VenueDTO
import com.bookmyshow.feature_one.model.ShowTime
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.util.Utility
import java.util.Calendar


fun ShowTimeDTO.toDomain(): ShowTime? {
    //we can log as needed
    val showDateCode = this.showDateCode

    //we could use LocalTime and LocatDateTime but for api < 26 support is limited
    if (showDateCode != null) {
        val mCal = Calendar.getInstance()
        mCal.time = Utility.parseRawTime(showDateCode) ?: return null
        val HH = mCal[Calendar.HOUR_OF_DAY]
        val mm = mCal[Calendar.MINUTE]

        return ShowTime(HH, mm, this.showTime)
    }

    return null
}

fun VenueDTO.toDomain(): Venue? {

    val parsedDate = Utility.parseRawDate(
        this.showDate ?: return null
    ) ?: return null

    return Venue(
        this.name ?: "-",
        parsedDate,
        this.showDate,
        this.showtimes?.mapNotNull { it.toDomain() })
}