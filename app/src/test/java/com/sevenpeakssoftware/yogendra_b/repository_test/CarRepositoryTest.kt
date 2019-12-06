package com.sevenpeakssoftware.yogendra_b.repository_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import com.sevenpeakssoftware.yogendra_b.api.FetchDataService
import com.sevenpeakssoftware.yogendra_b.api_test.ApiUtil.successCall
import com.sevenpeakssoftware.yogendra_b.model.CarApiResponse
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.model.room.CarDao
import com.sevenpeakssoftware.yogendra_b.repository.CarListRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CarRepositoryTest {

    private lateinit var repository: CarListRepository
    private val carDao = mock<CarDao>()

    private val service = mock<FetchDataService>()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        repository = CarListRepository(service,carDao)
    }

    @Test
    fun loadCarListFromNetwork() {
        val loadFromDB = MutableLiveData<List<Car>>()
        whenever(carDao.getAllCarList()).thenReturn(loadFromDB)

        val mockResponse = CarApiResponse("", emptyList(), "")
        val call = successCall(mockResponse)
        whenever(service.fetchCars()).thenReturn(call)

        val data = repository.loadCars(false)
        verify(carDao).getAllCarList()
        verifyNoMoreInteractions(service)

        val observer = mock<Observer<Resource<List<Car>>>>()
        data.observeForever(observer)
        verifyNoMoreInteractions(service)
        val updatedData = MutableLiveData<List<Car>>()
        whenever(carDao.getAllCarList()).thenReturn(updatedData)

        loadFromDB.postValue(null)
        verify(observer).onChanged(Resource.loading(null))
        verify(service).fetchCars()
        verify(carDao).insertCarList(mockResponse.content)

        updatedData.postValue(mockResponse.content)
        verify(observer).onChanged(Resource.success(mockResponse.content))
    }

}