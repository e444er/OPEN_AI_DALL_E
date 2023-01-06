package com.e444er.ai_dall_e.domain.use_case

import com.e444er.ai_dall_e.data.model.RequestBody
import com.e444er.ai_dall_e.domain.repository.DallERepository
import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(private val repository: DallERepository) {
    operator fun invoke(requestBody: RequestBody) = repository.generateImage(requestBody)
}