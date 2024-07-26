package com.nithiann.alarm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.usecase.AddAlarm
import com.nithiann.alarm.domain.usecase.DeleteAlarm
import com.nithiann.alarm.domain.usecase.GetAlarms
import com.nithiann.alarm.domain.usecase.UpdateAlarm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(
    private val getAlarms: GetAlarms,
    private val addAlarm: AddAlarm,
    private val updateAlarm: UpdateAlarm,
    private val deleteAlarm: DeleteAlarm
) : ViewModel() {

    val alarms: LiveData<List<Alarm>> = getAlarms().asLiveData()

    fun addAlarm(alarm: Alarm) {
        viewModelScope.launch {
            addAlarm(alarm)
        }
    }

    fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch {
            updateAlarm(alarm)
        }
    }

    fun deleteAlarm(id: Long) {
        viewModelScope.launch {
            deleteAlarm(id)
        }
    }
}