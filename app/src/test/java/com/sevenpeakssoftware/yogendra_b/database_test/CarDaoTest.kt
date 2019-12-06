package com.sevenpeakssoftware.yogendra_b.database_test

import com.sevenpeakssoftware.yogendra_b.model.room.Car
import com.sevenpeakssoftware.yogendra_b.utils.LiveDataTestUtil
import com.sevenpeakssoftware.yogendra_b.utils.MockTestUtil.Companion.mockCar
import com.sevenpeakssoftware.yogendra_b.utils.MockTestUtil.Companion.mockCarList
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class CarDaoTest : LocalDatabase() {

    @Test
    fun insertAndReadTest() {
        db.carDao().insertCarList(mockCarList())
        val loadFromDB = LiveDataTestUtil.getValue(db.carDao().getAllCarList())[0]
        MatcherAssert.assertThat(loadFromDB.title, CoreMatchers.`is`(""))
        MatcherAssert.assertThat(loadFromDB.id, CoreMatchers.`is`(1))
    }

    @Test
    fun updateAndReadTest() {
        val carList = ArrayList<Car>()
        val car = mockCar()
        carList.add(car)
        db.carDao().insertCarList(carList)

        val loadFromDB = db.carDao().getAllCarList()
        MatcherAssert.assertThat(loadFromDB.value?.get(0)?.id, CoreMatchers.`is`(1))

        car.tags = listOf("test car tag")
        db.carDao().updateCar(car)

        val updated = db.carDao().getAllCarList()
        MatcherAssert.assertThat(updated.value?.get(0)?.tags, CoreMatchers.`is`(listOf("test car tag")))
    }
}
