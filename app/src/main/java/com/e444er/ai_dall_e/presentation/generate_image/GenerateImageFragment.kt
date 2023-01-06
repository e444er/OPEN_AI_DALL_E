package com.e444er.ai_dall_e.presentation.generate_image

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.e444er.ai_dall_e.R
import com.e444er.ai_dall_e.common.*
import com.e444er.ai_dall_e.databinding.FragmentGenerateImageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenerateImageFragment : Fragment(R.layout.fragment_generate_image) {

    private val viewModel: GenerateImageViewModel by viewModels()
    private val binding by viewBinding(FragmentGenerateImageBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewCollect()
    }

    private fun initViewCollect() {
        with(viewModel) {
            with(binding) {
                generateButton.setOnClickListener {

                    if (promptEditText.text.toString().isEmpty().not()) {
                        val imageSize = if (size256.isChecked) {
                            Sizes.SIZE_256
                        } else if (size512.isChecked) {
                            Sizes.SIZE_512
                        } else {
                            Sizes.SIZE_1024
                        }
                        generateImage(promptEditText.text.toString(), 4, imageSize)
                    } else {
                        promptInputLayout.error = getString(R.string.enter_description)
                    }


                }
//                generatedImageCard.applyClickShrink()
//                generatedImageCard2.applyClickShrink()
//                generatedImageCard3.applyClickShrink()
//                generatedImageCard4.applyClickShrink()

                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                    state.collect { response ->
                        when (response) {
                            is Resource.Loading -> {
                                generateButton.startAnimation()
                                shimmerLayout.apply {
                                    startShimmer()
                                    visible()
                                }
                                generatedImagesGrid.gone()
                            }
                            is Resource.Success -> {
                                shimmerLayout.apply {
                                    stopShimmer()
                                    gone()
                                }
                                generatedImagesGrid.visible()

                                generateButton.revertAnimation {
                                    generateButton.setBackgroundResource(R.drawable.rounded_bg3)
                                }

                                generatedImageView.glideImage(response.data.data[0].url)
                                generatedImageView2.glideImage(response.data.data[1].url)
                                generatedImageView3.glideImage(response.data.data[2].url)
                                generatedImageView4.glideImage(response.data.data[3].url)


                                generatedImageCard.setOnClickListener {
                                    showImageFullPage(response.data.data[0].url)
                                }
                                generatedImageCard2.setOnClickListener {
                                    showImageFullPage(response.data.data[1].url)
                                }
                                generatedImageCard3.setOnClickListener {
                                    showImageFullPage(response.data.data[2].url)
                                }
                                generatedImageCard4.setOnClickListener {
                                    showImageFullPage(response.data.data[3].url)
                                }

                            }
                            is Resource.Error -> {
                                shimmerLayout.apply {
                                    stopShimmer()
                                    gone()
                                }
                                generatedImagesGrid.gone()

                                generateButton.revertAnimation {
                                    generateButton.setBackgroundResource(R.drawable.rounded_bg3)
                                }
                                Toast.makeText(requireActivity(), response.throwable.localizedMessage, Toast.LENGTH_SHORT).show()

                                Log.e("Response", response.throwable.localizedMessage ?: "Error")
                            }
                            else -> {}
                        }
                    }
                }
            }

        }
    }

    private fun showImageFullPage(imageUrl: String) {
        findNavController().navigate(
            GenerateImageFragmentDirections.actionGenerateImageFragmentToImageDetailFragment(
                imageUrl
            )
        )
    }
}