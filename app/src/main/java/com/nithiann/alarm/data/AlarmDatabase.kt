package com.nithiann.alarm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nithiann.alarm.data.DAO.AlarmDAO
import com.nithiann.alarm.data.helpers.LocalTimeConverter
import com.nithiann.alarm.domain.model.Alarm

@TypeConverters(LocalTimeConverter::class)
@Database(entities = [Alarm::class], version = 1, exportSchema = false)
abstract class AlarmDatabase: RoomDatabase() {
    abstract fun alarmDao(): AlarmDAO
}