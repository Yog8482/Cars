package com.sevenpeakssoftware.yogendra_b.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sevenpeakssoftware.yogendra_b.utilities.CarContentListConvertor
import com.sevenpeakssoftware.yogendra_b.utilities.StringListConverter

@Database(entities = [(Car::class)], version = 1, exportSchema = false)
@TypeConverters(value = [(StringListConverter::class), (CarContentListConvertor::class)])
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}