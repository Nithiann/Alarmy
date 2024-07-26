package com.nithiann.alarm.domain.usecase

import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow

class GetAlarms(private val alarmRepository: AlarmRepository) {
    operator fun invoke(): Flow<List<Alarm>> {
        return alarmRepository.getAlarms()
    }
}