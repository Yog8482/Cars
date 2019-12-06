package com.sevenpeakssoftware.yogendra_b.viewmodel_test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import com.sevenpeakssoftware.yogendra_b.api.FetchDataService
import com.sevenpeakssoftware.yogendra_b.api_test.ApiUtil
import com.sevenpeakssoftware.yogendra_b.model.CarApiResponse
import com.sevenpeakssoftware.yogendra_b.model.Resource
import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.model.room.CarDao
import com.sevenpeakssoftware.yogendra_b.repository.CarListRepository
import com.sevenpeakssoftware.yogendra_b.utils.MockTestUtil.Companion.mockCar
import com.sevenpeakssoftware.yogendra_b.viewmodel.CarsMainActivityViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CarMainActivityViewModelTest {
    private lateinit var viewModel: CarsMainActivityViewModel

    private lateinit var carRepository: CarListRepository

    private val carDao = mock<CarDao>()

    private val fetchdataService = mock<FetchDataService>()


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        carRepository = CarListRepository(fetchdataService, carDao)
        viewModel = CarsMainActivityViewModel(carRepository)
    }

    @Test
    fun loadCarList() {
        val loadFromDB = MutableLiveData<List<Car>>()
        whenever(carDao.getAllCarList()).thenReturn(loadFromDB)

        val mockResponse = CarApiResponse("", emptyList(), "")
        val call = ApiUtil.successCall(mockResponse)
        whenever(fetchdataService.fetchCars()).thenReturn(call)

        val data = viewModel.carListLiveData
        val observer = mock<Observer<Resource<List<Car>>>>()
        data.observeForever(observer)

        viewModel.refreshCarPage(false)
        verify(carDao).getAllCarList()
        verifyNoMoreInteractions(fetchdataService)

        val mockCarList = ArrayList<Car>()
        mockCarList.add(mockCar())
        loadFromDB.postValue(mockCarList)
        verify(observer).onChanged(
            Resource.success(viewModel.getCarListValues()!!.data)
        )
    }

}