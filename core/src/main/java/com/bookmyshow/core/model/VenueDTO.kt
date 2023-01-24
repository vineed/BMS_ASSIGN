package com.bookmyshow.core.model

import com.google.gson.annotations.SerializedName

data class VenueDTO(
    @SerializedName("name") val name: String? = null,//if "name" field not present in json then set null similarly we can assign "" also
    @SerializedName("showDate") val showDate: String? = null,
    @SerializedName("showtimes") val showtimes: List<ShowTimeDTO>? = emptyList(),
)