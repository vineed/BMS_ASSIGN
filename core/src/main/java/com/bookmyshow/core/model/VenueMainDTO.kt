package com.bookmyshow.core.model

import com.google.gson.annotations.SerializedName

data class VenueMainDTO(@SerializedName("venues") val venueDTOList: List<VenueDTO>? = emptyList())