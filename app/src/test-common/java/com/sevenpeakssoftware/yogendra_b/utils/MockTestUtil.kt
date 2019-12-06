package com.sevenpeakssoftware.yogendra_b.utils

import com.sevenpeakssoftware.yogendra_b.model.room.Car

class MockTestUtil {

    companion object {
        fun mockCar() = Car(1, "", "", "", "", 123, 123, emptyList(), emptyList())

        fun mockCarList(): List<Car> {
            val cars = ArrayList<Car>()
            cars.add(mockCar())
            cars.add(mockCar())
            cars.add(mockCar())
            return cars
        }
    }
}