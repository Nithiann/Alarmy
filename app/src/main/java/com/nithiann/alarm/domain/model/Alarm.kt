package com.nithiann.alarm.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: LocalTime,
    val isEnabled: Boolean,
    val label: String,
    val difficulty: Difficulty,
    val sound: String,
    val repeatDays: List<DayOfWeek>?
)
