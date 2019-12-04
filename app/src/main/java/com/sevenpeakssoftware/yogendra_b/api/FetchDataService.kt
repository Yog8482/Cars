package com.sevenpeakssoftware.yogendra_b.api

import androidx.lifecycle.LiveData
import com.sevenpeakssoftware.yogendra_b.api.ApiResponse
import com.sevenpeakssoftware.yogendra_b.model.CarApiResponse
import com.sevenpeakssoftware.yogendra_b.utilities.GET_ARTICALS_ENDPOINT
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface FetchDataService {
    /**
     *
     * Get List of cars from api
     *
     */

    @GET(GET_ARTICALS_ENDPOINT)
    fun fetchCars(): LiveData<ApiResponse<CarApiResponse>>
}