package com.sevenpeakssoftware.yogendra_b.api_test

import com.sevenpeakssoftware.yogendra_b.api.ApiResponse
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class ApiResponseTest {

    @Test
    fun exception() {
        val exception = Exception("foo")
        val apiResponse = ApiResponse<String>(exception)
        MatcherAssert.assertThat(apiResponse.isSuccessful, CoreMatchers.`is`(false))
        MatcherAssert.assertThat<String>(apiResponse.body, CoreMatchers.nullValue())
        MatcherAssert.assertThat(apiResponse.code, CoreMatchers.`is`(500))
        MatcherAssert.assertThat(apiResponse.message, CoreMatchers.`is`("foo"))
    }

    @Test
    fun success() {
        val apiResponse = ApiResponse(Response.success("foo"))
        MatcherAssert.assertThat(apiResponse.isSuccessful, CoreMatchers.`is`(true))
        MatcherAssert.assertThat(apiResponse.code, CoreMatchers.`is`(200))
        MatcherAssert.assertThat<String>(apiResponse.body, CoreMatchers.`is`("foo"))
        MatcherAssert.assertThat(apiResponse.message, CoreMatchers.nullValue())
    }
}