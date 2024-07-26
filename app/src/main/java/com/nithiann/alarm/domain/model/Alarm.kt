package com.nithiann.alarm.domain.model

import java.time.DayOfWeek
import java.time.LocalTime

data class Alarm(
    val id: Long,
    val time: LocalTime,
    val isEnabled: Boolean,
    val label: String,
    val repeatDays: List<DayOfWeek>
)
