package com.e444er.ai_dall_e.di

import com.e444er.ai_dall_e.data.source.DallEService
import com.e444er.ai_dall_e.data.source.RemoteDateSourceImpl
import com.e444er.ai_dall_e.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDateSource(remoteService: DallEService): RemoteDataSource =
        RemoteDateSourceImpl(remoteService)
}