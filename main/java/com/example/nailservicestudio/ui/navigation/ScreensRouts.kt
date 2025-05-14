package com.example.nailservicestudio.ui.navigation

sealed class ScreensRouts(val route: String) {
    data object HomeScreen : ScreensRouts("HomeScreen")
    data object LogInScreen : ScreensRouts("LogInScreen")
    data object SignUpScreen : ScreensRouts("SignUpScreen")
    data object MastersListScreen : ScreensRouts("MastersListScreen")
    data object MasterServicesScreen : ScreensRouts("MasterServicesScreen")
    data object PromoScreen : ScreensRouts("PromoScreen")
    data object ProfileScreen : ScreensRouts("ProfileScreen")
    data object ServicesScreen : ScreensRouts("ServicesScreen")
}