package com.nithiann.alarm.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nithiann.alarm.domain.model.Alarm

interface AlarmDAO {

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): LiveData<List<Alarm>>

    suspend fun getById(id: Int): Alarm?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alarm: Alarm): Int

    @Update
    suspend fun update(alarm: Alarm)

    @Delete
    suspend fun delete(id: Int)
}