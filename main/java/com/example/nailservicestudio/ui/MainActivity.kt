package com.example.nailservicestudio.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.nailservicestudio.ui.navigation.NavGraph
import com.example.nailservicestudio.ui.navigation.ScreensRouts
import com.example.nailservicestudio.ui.theme.NailServiceStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            NailServiceStudioTheme {
                NavGraph(
                    navHostController = navController,
                    startScreen = ScreensRouts.LogInScreen.route
                )
            }
        }
    }
}