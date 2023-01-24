package com.bookmyshow.feature_one.repository

import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.feature_one.extensions.toDomain
import com.bookmyshow.feature_one.model.Venue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class ShowTimesRepository @Inject constructor(
    private val networkProvider: NetworkProvider
) {

    private val api: ShowTimesAPI
        get() = networkProvider.getApi(
            apiClass = ShowTimesAPI::class.java,
            baseUrl = "https://demo2782755.mockable.io"
        )

    //We can convert DTO to application specific model here
    public suspend fun getAllVenues(): Result<out List<Venue>> = withContext(Dispatchers.IO) {
        return@withContext try {
            Result.Success(api.getShowTimes()?.venueDTOList?.mapNotNull { it.toDomain() }?: emptyList())
        } catch (ex: Exception) {
            ex.printStackTrace()
            Result.Failure("Failed to fetch venues...")
        }
    }
}