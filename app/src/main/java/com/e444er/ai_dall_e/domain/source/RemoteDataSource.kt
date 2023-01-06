package com.e444er.ai_dall_e.domain.source

import com.e444er.ai_dall_e.data.model.GeneratedImage
import com.e444er.ai_dall_e.data.model.RequestBody

interface RemoteDataSource {
    suspend fun generateImage(requestBody: RequestBody): GeneratedImage
}