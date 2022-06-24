package com.diekvoss.roomdemo

import androidx.room.TypeConverter
import java.util.*

class DataTypeConverter {

    @TypeConverter
    fun longToDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToLong(value: Date?): Long? {
        return value?.time
    }
}