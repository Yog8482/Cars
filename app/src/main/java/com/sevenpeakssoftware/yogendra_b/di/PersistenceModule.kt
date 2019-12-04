package com.sevenpeakssoftware.yogendra_b.di


import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.sevenpeakssoftware.yogendra_b.model.room.AppDatabase
import com.sevenpeakssoftware.yogendra_b.model.room.CarDao

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "TheCars.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providecarDao(@NonNull database: AppDatabase): CarDao {
        return database.carDao()
    }
}
