package com.e444er.ai_dall_e.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e444er.ai_dall_e.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}