package com.nithiann.alarm.domain.usecase

import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.repository.AlarmRepository

class AddAlarm(private val alarmRepository: AlarmRepository) {
    suspend operator fun invoke(alarm: Alarm): Long {
        return alarmRepository.addAlarm(alarm);
    }

}