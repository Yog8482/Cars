package com.sevenpeakssoftware.yogendra_b.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sevenpeakssoftware.yogendra_b.factory.AppViewModelFactory
import com.sevenpeakssoftware.yogendra_b.viewmodel.CarsMainActivityViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(CarsMainActivityViewModel::class)
  internal abstract fun bindMainActivityViewModels(mainActivityViewModel: CarsMainActivityViewModel): ViewModel

  @Binds
  internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
