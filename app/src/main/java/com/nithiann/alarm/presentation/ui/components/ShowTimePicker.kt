package com.nithiann.alarm.presentation.ui.components

import android.app.TimePickerDialog
import android.content.Context
import java.util.*

fun showTimePickerDialog(context: Context, onTimeSet: (hour: Int, minute: Int) -> Unit) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    TimePickerDialog(context, { _, selectedHour, selectedMinute ->
        onTimeSet(selectedHour, selectedMinute)
    }, hour, minute, true).show()
}