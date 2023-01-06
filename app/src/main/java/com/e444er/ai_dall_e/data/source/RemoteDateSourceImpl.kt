package com.e444er.ai_dall_e.data.source

import com.e444er.ai_dall_e.data.model.GeneratedImage
import com.e444er.ai_dall_e.data.model.RequestBody
import com.e444er.ai_dall_e.domain.source.RemoteDataSource

class RemoteDateSourceImpl(private val remoteService: DallEService) : RemoteDataSource {

    override suspend fun generateImage(
        requestBody: RequestBody
    ): GeneratedImage {
        return remoteService.generateImage(requestBody)
    }
}