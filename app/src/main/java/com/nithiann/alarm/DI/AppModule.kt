package com.nithiann.alarm.DI

import com.nithiann.alarm.data.repository.AlarmRepositoryImpl
import com.nithiann.alarm.domain.repository.AlarmRepository
import com.nithiann.alarm.domain.usecase.AddAlarm
import com.nithiann.alarm.domain.usecase.DeleteAlarm
import com.nithiann.alarm.domain.usecase.GetAlarms
import com.nithiann.alarm.domain.usecase.UpdateAlarm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAlarmRepository(): AlarmRepository {
        return AlarmRepositoryImpl()
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