package com.e444er.ai_dall_e.data.source

import com.e444er.ai_dall_e.common.Constants.GENERATE_IMAGE
import com.e444er.ai_dall_e.data.model.GeneratedImage
import com.e444er.ai_dall_e.data.model.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface DallEService {

    @POST(GENERATE_IMAGE)
    suspend fun generateImage(@Body body: RequestBody): GeneratedImage

}