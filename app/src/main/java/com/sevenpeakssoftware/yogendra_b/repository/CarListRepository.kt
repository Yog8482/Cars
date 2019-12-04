package com.sevenpeakssoftware.yogendra_b.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.sevenpeakssoftware.yogendra_b.api.ApiResponse
import com.sevenpeakssoftware.yogendra_b.api.FetchDataService
import com.sevenpeakssoftware.yogendra_b.model.CarApiResponse
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.model.room.CarDao

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarListRepository @Inject
constructor(
    val fetchDataService: FetchDataService,
    val carDao: CarDao
) : Repository {

    init {
        Log.d("carListrepository", "Injection DiscoverRepository")
    }

    fun loadCars(): LiveData<Resource<List<Car>>> {
        return object : NetworkBoundRepository<List<Car>, CarApiResponse>() {
            override fun saveFetchData(items: CarApiResponse) {
                carDao.insertCarList(cars = items.content)
            }

            override fun shouldFetch(data: List<Car>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<Car>> {
                return carDao.getAllCarList()
            }

            override fun fetchService(): LiveData<ApiResponse<CarApiResponse>> {
                return fetchDataService.fetchCars()
            }


            override fun onFetchFailed(message: String?) {
                Log.d("carListrepository", "onFetchFailed $message")
            }
        }.asLiveData()
    }

}
