package com.e444er.ai_dall_e.domain.use_case

import android.app.Application
import com.e444er.ai_dall_e.common.DownloadImage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DownloadImageUseCase @Inject constructor(private val application: Application) :
    DownloadImage() {
    operator fun invoke(url: String) = downloadImageFromURL(url, application)
}