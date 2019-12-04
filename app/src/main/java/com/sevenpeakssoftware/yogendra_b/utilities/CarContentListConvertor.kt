package com.sevenpeakssoftware.yogendra_b.utilities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sevenpeakssoftware.yogendra_b.model.CarContent
import com.sevenpeakssoftware.yogendra_b.model.room.Car

open class CarContentListConvertor {
    @TypeConverter
    fun fromString(value: String): List<CarContent>? {
        val listtype = object : TypeToken<List<CarContent>>() {}.type
        return Gson().fromJson<List<CarContent>>(value, listtype)
    }

    @TypeConverter
    fun fromList(list: List<CarContent>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}