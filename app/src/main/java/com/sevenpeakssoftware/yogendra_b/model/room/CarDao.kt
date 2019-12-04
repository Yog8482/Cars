package com.sevenpeakssoftware.yogendra_b.model.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCarList(cars: List<Car>)

    @Update
    fun updateCar(car: Car)

    @Query("SELECT * FROM Car")
    fun getAllCarList(): LiveData<List<Car>>
}