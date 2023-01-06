package com.e444er.ai_dall_e.data.repository

import com.e444er.ai_dall_e.common.Resource
import com.e444er.ai_dall_e.data.model.RequestBody
import com.e444er.ai_dall_e.domain.repository.DallERepository
import com.e444er.ai_dall_e.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.flow

class DallERepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DallERepository {

    override fun generateImage(
        requestBody: RequestBody
    ) = flow {
        emit(Resource.Loading)

        try {
            val response = remoteDataSource.generateImage(requestBody)
            emit(Resource.Success(response))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }
}