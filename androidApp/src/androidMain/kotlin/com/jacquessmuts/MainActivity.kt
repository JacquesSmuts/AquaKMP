package com.jacquessmuts

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import data.WaterRepository
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val waterRepository: WaterRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainView(waterRepository)
        }
    }
}