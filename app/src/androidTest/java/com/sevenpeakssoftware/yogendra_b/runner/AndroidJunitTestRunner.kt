package com.sevenpeakssoftware.yogendra_b.runner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.sevenpeakssoftware.yogendra_b.TestCarApplication

@Suppress("unused")
class AndroidJunitTestRunner : AndroidJUnitRunner() {
  @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
  override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
    return super.newApplication(cl, TestCarApplication::class.java.name, context)
  }
}
