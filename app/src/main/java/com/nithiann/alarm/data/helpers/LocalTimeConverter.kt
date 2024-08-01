package com.nithiann.alarm.data.helpers

import androidx.room.TypeConverter
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object LocalTimeConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_TIME

    @TypeConverter
    @JvmStatic
    fun fromLocalTime(localTime: LocalTime?): String? {
        return localTime?.format(formatter)
    }

    @TypeConverter
    @JvmStatic
    fun toLocalTime(timeString: String?): LocalTime? {
        return timeString?.let { LocalTime.parse(it, formatter) }
    }

    @TypeConverter
    @JvmStatic
    fun fromDayOfWeekList(days: List<DayOfWeek>?): String? {
        return days?.joinToString(separator = ",") { it.name }
    }

    @TypeConverter
    @JvmStatic
    fun toDayOfWeekList(data: String?): List<DayOfWeek>? {
        return data?.split(",")?.map { DayOfWeek.valueOf(it) }
    }
}