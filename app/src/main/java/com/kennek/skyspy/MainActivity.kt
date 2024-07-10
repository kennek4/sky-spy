package com.kennek.skyspy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.kennek.skyspy.presentation.viewmodels.WeatherViewModel
import com.kennek.skyspy.ui.theme.SkySpyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val vm: WeatherViewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkySpyTheme {
                Button(
                    onClick = {
                        vm.apiCall()
                    })
                {
                    Text(text = "Api Call")
                }
            }
        }
    }
}
