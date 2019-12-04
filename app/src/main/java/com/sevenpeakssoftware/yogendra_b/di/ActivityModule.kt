package com.sevenpeakssoftware.yogendra_b.di

import com.sevenpeakssoftware.yogendra_b.view.ui.CarsMainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector
  internal abstract fun contributeMainActivity(): CarsMainActivity

}
