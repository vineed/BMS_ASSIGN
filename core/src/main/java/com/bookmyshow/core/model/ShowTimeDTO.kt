package com.bookmyshow.core.model

import com.google.gson.annotations.SerializedName

data class ShowTimeDTO(
    @SerializedName("showTime") val showTime: String? = null,
    @SerializedName("showDateCode") val showDateCode: Long? = -1,
)