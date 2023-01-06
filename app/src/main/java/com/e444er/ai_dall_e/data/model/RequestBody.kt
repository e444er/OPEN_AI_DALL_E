package com.e444er.ai_dall_e.data.model

import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("n")
    val n: Int,
    @SerializedName("prompt")
    val prompt: String,
    @SerializedName("size")
    val size: String
)