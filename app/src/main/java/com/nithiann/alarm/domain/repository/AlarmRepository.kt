package com.nithiann.alarm.domain.repository

import androidx.lifecycle.LiveData
import com.nithiann.alarm.domain.model.Alarm
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAlarms(): LiveData<List<Alarm>>
    suspend fun getAlarmById(id: Int): Alarm?
    suspend fun addAlarm(alarm: Alarm): Long
    suspend fun updateAlarm(alarm: Alarm)
    suspend fun deleteAlarm(alarm: Alarm)
    suspend fun deleteAlarmById(id: Int)
}