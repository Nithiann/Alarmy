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
import com.nithiann.alarm.domain.model.Difficulty
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlarmFormDialog(onDismiss: () -> Unit, onSave: (Alarm) -> Unit) {
    var time by remember { mutableStateOf("") }
    var label by remember { mutableStateOf("") }
    var difficulty by remember { mutableStateOf(Difficulty.EASY) }
    var customSelected by remember { mutableStateOf(false) }
    var minValue by remember { mutableStateOf("") }
    var maxValue by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val difficulties = Difficulty.entries.toTypedArray()

    Dialog(onDismissRequest = onDismiss) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    TextButton(
                        onClick = {
                            showTimePickerDialog(context) { hour, minute ->
                                time = String.format("%02d:%02d", hour, minute)
                            }
                        }
                    ) {
                        Text(text = if (time.isEmpty()) "Select Time" else "Time: $time")
                    }
                }

                OutlinedTextField(
                    value = label,
                    onValueChange = { label = it },
                    label = { Text("Label") },
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Difficulty Buttons
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {
                    OutlinedTextField(
                        value = difficulty.text,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Difficulty") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        difficulties.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option.text) },
                                onClick = {
                                    difficulty = option
                                    customSelected = option == Difficulty.CUSTOM
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                // Custom Values Fields
                if (customSelected) {

                    OutlinedTextField(
                        value = minValue,
                        onValueChange = { minValue = it },
                        label = { Text("Min Value") },
                    )
                    OutlinedTextField(
                        value = maxValue,
                        onValueChange = { maxValue = it },
                        label = { Text("Max Value") },
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = {
                            onSave(
                                Alarm(
                                    time = LocalTime.parse(time),
                                    label = label,
                                    difficulty = difficulty,
                                    isEnabled = false,
                                    repeatDays = emptyList(),
                                    sound = ""
                                )
                            )
                            onDismiss()
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}