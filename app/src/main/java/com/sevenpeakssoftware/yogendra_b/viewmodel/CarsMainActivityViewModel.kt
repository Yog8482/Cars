package com.sevenpeakssoftware.yogendra_b.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.repository.CarListRepository
import com.sevenpeakssoftware.yogendra_b.utilities.AbsentLiveData
import javax.inject.Inject

class CarsMainActivityViewModel @Inject
constructor(
    private val carDataRepository: CarListRepository
) : ViewModel() {

    var carListLiveData: LiveData<Resource<List<Car>>>
    private var carPageRefreshLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        Log.d("CarmainActVM", "car MainActivity view model")

        carListLiveData = carPageRefreshLiveData.switchMap {
            carPageRefreshLiveData.value?.let { carDataRepository.loadCars(it) }
                ?: AbsentLiveData.create()
        }

    }

    fun refreshCarPage(isrefresh: Boolean) = carPageRefreshLiveData.postValue(isrefresh)

    fun getCarListValues() = carListLiveData.value

}