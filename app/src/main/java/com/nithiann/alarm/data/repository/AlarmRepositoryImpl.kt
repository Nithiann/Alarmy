package com.nithiann.alarm.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlarmRepositoryImpl : AlarmRepository {
    private val alarmList = mutableListOf<Alarm>()

    override fun getAlarms(): Flow<List<Alarm>> = flow {
        emit(alarmList)
    }

    override suspend fun getAlarmById(id: Long): Alarm? {
        return alarmList.find { it.id == id }
    }

    override suspend fun addAlarm(alarm: Alarm): Long {
        val id = (alarmList.maxByOrNull { it.id }?.id ?: 0) + 1
        alarmList.add(alarm.copy(id = id))
        return id
    }

    override suspend fun updateAlarm(alarm: Alarm) {
        val index = alarmList.indexOfFirst { it.id == alarm.id }
        if (index != -1) {
            alarmList[index] = alarm
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun deleteAlarm(id: Long) {
        alarmList.removeIf { it.id == id }
    }
}