
package com.sevenpeakssoftware.yogendra_b.api

import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val originalUrl = originalRequest.url()

    val requestBuilder = originalRequest.newBuilder().url(originalUrl)
    val request = requestBuilder.build()
    return chain.proceed(request)
  }
}
