package com.myosetpaing.endtoend.persistence.typeconverters

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(longDate: Long): Date {
        val date= Date()
        date.time=longDate
        return date
    }
}