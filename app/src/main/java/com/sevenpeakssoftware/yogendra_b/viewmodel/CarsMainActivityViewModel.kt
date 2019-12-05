package com.sevenpeakssoftware.yogendra_b.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.repository.CarListRepository
import javax.inject.Inject

class CarsMainActivityViewModel @Inject
constructor(
    private val carDataRepository: CarListRepository
) : ViewModel() {

    val carListLiveData: LiveData<Resource<List<Car>>>


    init {
        Log.d("CarmainActVM", "car MainActivity view model")

        carListLiveData = carDataRepository.loadCars()

    }

    fun getCarListValues() = carListLiveData.value

}