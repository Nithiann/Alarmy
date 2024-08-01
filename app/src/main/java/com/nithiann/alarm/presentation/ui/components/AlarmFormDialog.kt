package com.nithiann.alarm.presentation.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.nithiann.alarm.domain.model.Alarm
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlarmFormDialog(onDismiss: () -> Unit, onSave: (Alarm) -> Unit) {
    var time by remember { mutableStateOf("") }
    var label by remember { mutableStateOf("") }
    var difficulty by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        TextButton(
            onClick = {
                showTimePickerDialog(context) { hour, minute ->
                    time = String.format("%02d:%02d", hour, minute)
                }
            }
        ) {
            Text(text = if (time.isEmpty()) "Select Time" else "Time: $time")
        }

        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = { Text("Label") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = difficulty,
            onValueChange = { difficulty = it },
            label = { Text("Difficulty") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                onSave(Alarm(time = LocalTime.parse(time), label = label, difficulty = difficulty.toInt(), isEnabled = false, repeatDays = emptyList(), sound = ""))
                onDismiss()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save")
        }
    }
}