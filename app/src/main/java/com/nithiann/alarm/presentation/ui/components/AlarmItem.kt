package com.nithiann.alarm.presentation.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nithiann.alarm.domain.model.Alarm
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AlarmItem(
    alarm: Alarm,
    onToggleAlarm: (Boolean) -> Unit,
    onEditAlarm: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.DarkGray, shape = RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = alarm.time.format(DateTimeFormatter.ofPattern("hh:mm a")),
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = alarm.repeatDays!!.joinToString(", "),
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = alarm.isEnabled,
                onCheckedChange = onToggleAlarm,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Magenta,
                    uncheckedThumbColor = Color.Gray
                )
            )

            Button(
                onClick = onEditAlarm,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Edit", color = Color.White)
            }
        }
    }
}