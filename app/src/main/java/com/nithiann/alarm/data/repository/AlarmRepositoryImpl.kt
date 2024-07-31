package com.nithiann.alarm.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.nithiann.alarm.data.DAO.AlarmDAO
import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepositoryImpl @Inject constructor(private val alarmDao: AlarmDAO) : AlarmRepository {
    override fun getAlarms(): LiveData<List<Alarm>> = alarmDao.getAllAlarms()

    override suspend fun getAlarmById(id: Int): Alarm? {
        return alarmDao.getById(id)
    }

    override suspend fun addAlarm(alarm: Alarm): Int {
        return alarmDao.insert(alarm)
    }

    override suspend fun updateAlarm(alarm: Alarm) {
        return alarmDao.update(alarm)
    }

    override suspend fun deleteAlarm(id: Int) {
        return alarmDao.delete(id)
    }
}