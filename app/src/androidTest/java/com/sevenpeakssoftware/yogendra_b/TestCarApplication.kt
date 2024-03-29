package com.sevenpeakssoftware.yogendra_b

import com.sevenpeakssoftware.yogendra_b.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TestCarApplication : DaggerApplication() {

  private val appComponent = DaggerAppComponent.builder()
      .application(this)
      .build()

  override fun onCreate() {
    super.onCreate()
    appComponent.inject(this)
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return appComponent
  }
}
