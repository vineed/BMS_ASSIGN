package com.bookmyshow.feature_one.repository

import com.bookmyshow.core.model.VenueDTO
import com.bookmyshow.core.model.VenueMainDTO
import retrofit2.http.GET

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
interface ShowTimesAPI {

    @GET("/movie_showtimes")
    suspend fun getShowTimes(): VenueMainDTO
}