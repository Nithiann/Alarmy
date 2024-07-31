package com.nithiann.alarm.presentation.ui.components

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.nithiann.alarm.domain.model.Alarm

@SuppressLint("NewApi")
@Composable
fun AlarmList(
    alarms: List<Alarm>,
    onToggleAlarm: (Alarm, Boolean) -> Unit,
    onEditAlarm: (Alarm) -> Unit
) {
    LazyColumn {
        items(alarms) { alarm ->
            AlarmItem(
                alarm = alarm,
                onToggleAlarm = { isEnabled -> onToggleAlarm(alarm, isEnabled) },
                onEditAlarm = { onEditAlarm(alarm) }
            )
        }
    }
}