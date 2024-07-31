package com.nithiann.alarm.data

import androidx.room.RoomDatabase
import com.nithiann.alarm.data.DAO.AlarmDAO

abstract class AlarmDatabase: RoomDatabase() {
    abstract fun alarmDao(): AlarmDAO
}