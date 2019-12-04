package com.sevenpeakssoftware.yogendra_b.di

import com.sevenpeakssoftware.yogendra_b.compose.ViewModelActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ComposeModule {

  @ContributesAndroidInjector
  internal abstract fun contributeViewModelActivity(): ViewModelActivity

}
