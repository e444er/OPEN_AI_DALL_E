package com.e444er.ai_dall_e.di

import com.e444er.ai_dall_e.data.repository.DallERepositoryImpl
import com.e444er.ai_dall_e.domain.repository.DallERepository
import com.e444er.ai_dall_e.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDallERepository(remoteDataSource: RemoteDataSource): DallERepository =
        DallERepositoryImpl(remoteDataSource)
}