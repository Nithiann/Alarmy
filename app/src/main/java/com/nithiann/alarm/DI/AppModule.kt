package com.nithiann.alarm.DI

import android.content.Context
import androidx.room.Room
import com.nithiann.alarm.data.AlarmDatabase
import com.nithiann.alarm.data.DAO.AlarmDAO
import com.nithiann.alarm.data.repository.AlarmRepositoryImpl
import com.nithiann.alarm.domain.repository.AlarmRepository
import com.nithiann.alarm.domain.usecase.AddAlarm
import com.nithiann.alarm.domain.usecase.DeleteAlarm
import com.nithiann.alarm.domain.usecase.GetAlarms
import com.nithiann.alarm.domain.usecase.UpdateAlarm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAlarmDatabase(@ApplicationContext context: Context): AlarmDatabase {
        return Room.databaseBuilder(context, AlarmDatabase::class.java, "alarm_database").build()
    }

    @Singleton
    @Provides
    fun provideAlarmDao(database: AlarmDatabase) = database.alarmDao()

    @Singleton
    @Provides
    fun provideAlarmRepository(alarmDao: AlarmDAO): AlarmRepository {
        return AlarmRepositoryImpl(alarmDao)
    }

    @Provides
    @Singleton
    fun provideGetAlarmsUseCase(alarmRepository: AlarmRepository): GetAlarms {
        return GetAlarms(alarmRepository)
    }

    @Provides
    @Singleton
    fun provideAddAlarmUseCase(alarmRepository: AlarmRepository): AddAlarm {
        return AddAlarm(alarmRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateAlarmUseCase(alarmRepository: AlarmRepository): UpdateAlarm {
        return UpdateAlarm(alarmRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteAlarmUseCase(alarmRepository: AlarmRepository): DeleteAlarm {
        return DeleteAlarm(alarmRepository)
    }
}