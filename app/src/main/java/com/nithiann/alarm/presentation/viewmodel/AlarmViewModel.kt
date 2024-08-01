package com.nithiann.alarm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nithiann.alarm.domain.model.Alarm
import com.nithiann.alarm.domain.repository.AlarmRepository
import com.nithiann.alarm.domain.usecase.AddAlarm
import com.nithiann.alarm.domain.usecase.DeleteAlarm
import com.nithiann.alarm.domain.usecase.GetAlarms
import com.nithiann.alarm.domain.usecase.UpdateAlarm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(private val repository: AlarmRepository) : ViewModel() {

    val alarms: LiveData<List<Alarm>> = repository.getAlarms()

    fun insert(alarm: Alarm) = viewModelScope.launch {
        repository.addAlarm(alarm)
    }

    fun toggleAlarm(alarm: Alarm, isEnabled: Boolean) {
        viewModelScope.launch {
            repository.updateAlarm(alarm.copy(isEnabled = isEnabled))
        }
    }

    fun edit(alarm: Alarm) = viewModelScope.launch {
        // navigate
    }

    fun update(alarm: Alarm) = viewModelScope.launch {
        repository.updateAlarm(alarm)
    }

    fun delete(alarm: Alarm) = viewModelScope.launch {
        repository.deleteAlarm(alarm.id)
    }

    fun deleteAlarmById(id: Int) = viewModelScope.launch {
        repository.deleteAlarmById(id)
    }
}