package com.sevenpeakssoftware.yogendra_b.api

import android.util.Log
import retrofit2.Response
import java.io.IOException

@Suppress("MemberVisibilityCanBePrivate")
class ApiResponse<T> {
  val code: Int
  val body: T?
  val message: String?

  val isSuccessful: Boolean
    get() = code in 200..300
  val isFailure: Boolean

  constructor(error: Throwable) {
    this.code = 500
    this.body = null
    this.message = error.message
    this.isFailure = true
  }

  constructor(response: Response<T>) {
    this.code = response.code()

    if (response.isSuccessful) {
      this.body = response.body()
      this.message = null
      this.isFailure = false
    } else {
      var errorMessage: String? = null
      response.errorBody()?.let {
        try {
          errorMessage = response.errorBody()!!.string()
        } catch (ignored: IOException) {
         Log.e("ApiResponse", "error while parsing response")
        }
      }

      errorMessage?.apply {
        if (isNullOrEmpty() || trim { it <= ' ' }.isEmpty()) {
          errorMessage = response.message()
        }
      }

      this.body = null
      this.message = errorMessage
      this.isFailure = true
    }
  }
}
