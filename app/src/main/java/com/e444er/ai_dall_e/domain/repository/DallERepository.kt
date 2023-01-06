package com.e444er.ai_dall_e.domain.repository

import com.e444er.ai_dall_e.common.Resource
import com.e444er.ai_dall_e.data.model.GeneratedImage
import com.e444er.ai_dall_e.data.model.RequestBody
import kotlinx.coroutines.flow.Flow


interface DallERepository {
    fun generateImage(requestBody: RequestBody): Flow<Resource<GeneratedImage>>
}