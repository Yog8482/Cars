package com.sevenpeakssoftware.yogendra_b.di

import androidx.annotation.NonNull
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.sevenpeakssoftware.yogendra_b.api.FetchDataService
import com.sevenpeakssoftware.yogendra_b.api.LiveDataCallAdapterFactory
import com.sevenpeakssoftware.yogendra_b.api.RequestInterceptor
import com.sevenpeakssoftware.yogendra_b.utilities.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(RequestInterceptor())
      .addNetworkInterceptor(StethoInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(LiveDataCallAdapterFactory())
      .build()
  }

  @Provides
  @Singleton
  fun provideFetchDataService(@NonNull retrofit: Retrofit): FetchDataService {
    return retrofit.create(FetchDataService::class.java)
  }

}
