package com.sevenpeakssoftware.yogendra_b.network

import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.utilities.GET_ARTICALS_ENDPOINT
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CarsApi {
    /**
     *
     * Get List of cars from api
     *
     */

    @GET(GET_ARTICALS_ENDPOINT)
    fun getPosts(): Observable<Car>
}