package com.nithiann.alarm.presentation.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

    Dialog(onDismissRequest = onDismiss) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "New Alarm", style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = time,
                    onValueChange = { time = it },
                    label = { Text("Time") }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = label,
                    onValueChange = { label = it },
                    label = { Text("Label") }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = difficulty,
                    onValueChange = { difficulty = it },
                    label = { Text("Difficulty") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            val newAlarm = Alarm(
                                time = LocalTime.parse(time),
                                isEnabled = true,
                                label = label,
                                difficulty = difficulty.toInt(),
                                sound = "",
                                repeatDays = emptyList()
                            )
                            onSave(newAlarm)
                            onDismiss()
                        }
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}