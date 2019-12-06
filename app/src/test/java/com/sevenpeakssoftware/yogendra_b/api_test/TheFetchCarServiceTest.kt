package com.sevenpeakssoftware.yogendra_b.api_test

import com.sevenpeakssoftware.yogendra_b.api.FetchDataService
import com.sevenpeakssoftware.yogendra_b.utils.LiveDataTestUtil
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TheFetchCarServiceTest: ApiAbstract<FetchDataService>(){

    private lateinit var service: FetchDataService

    @Before
    fun initService() {
        this.service = createService(FetchDataService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun fetchCarListTest() {
        enqueueResponse("/db_car.json")
        val response = LiveDataTestUtil.getValue(service.fetchCars())
        MatcherAssert.assertThat(response.body?.content?.get(0)?.id, CoreMatchers.`is`(119302))
        MatcherAssert.assertThat(response.body?.status, CoreMatchers.`is`("success"))

    }

}