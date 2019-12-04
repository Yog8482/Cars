package com.sevenpeakssoftware.yogendra_b

import android.os.Build.FINGERPRINT
import com.facebook.stetho.Stetho
import com.sevenpeakssoftware.yogendra_b.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Suppress("unused")
class TheCarsApplication : DaggerApplication() {

  private val appComponent = DaggerAppComponent.builder()
    .application(this)
    .build()

  override fun onCreate() {
    super.onCreate()
    appComponent.inject(this)

    if (!isRobolectricUnitTest()) {
      Stetho.initializeWithDefaults(this)
    }
  }

  private fun isRobolectricUnitTest(): Boolean {
    return "robolectric" == FINGERPRINT
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return appComponent
  }
}
