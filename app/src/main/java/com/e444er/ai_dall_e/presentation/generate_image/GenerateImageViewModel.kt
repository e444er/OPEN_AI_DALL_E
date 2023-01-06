package com.e444er.ai_dall_e.presentation.generate_image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e444er.ai_dall_e.common.Constants.SIZE_1024
import com.e444er.ai_dall_e.common.Constants.SIZE_256
import com.e444er.ai_dall_e.common.Constants.SIZE_512
import com.e444er.ai_dall_e.common.Resource
import com.e444er.ai_dall_e.common.Sizes
import com.e444er.ai_dall_e.data.model.GeneratedImage
import com.e444er.ai_dall_e.data.model.RequestBody
import com.e444er.ai_dall_e.domain.use_case.GenerateImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GenerateImageViewModel @Inject constructor(
    private val generateImageUseCase: GenerateImageUseCase
) : ViewModel() {


    private val _state = MutableStateFlow<Resource<GeneratedImage>?>(null)
    val state = _state.asStateFlow()

    fun generateImage(prompt: String, n: Int, size: Sizes) = viewModelScope.launch {

        val sizeString = when (size) {
            Sizes.SIZE_256 -> SIZE_256
            Sizes.SIZE_512 -> SIZE_512
            Sizes.SIZE_1024 -> SIZE_1024
        }

        generateImageUseCase(RequestBody(n, prompt, sizeString)).collect {
            _state.emit(it)
        }
    }
}