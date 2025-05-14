package com.example.nailservicestudio.ui.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nailservicestudio.ui.screen.login.LogInScreen
import com.example.nailservicestudio.ui.screen.masterServices.MasterServicesScreen
import com.example.nailservicestudio.ui.screen.mastersList.MastersList
import com.example.nailservicestudio.ui.screen.home.HomeScreen
import com.example.nailservicestudio.ui.screen.profile.ProfileScreen
import com.example.nailservicestudio.ui.screen.promo.PromoScreen
import com.example.nailservicestudio.ui.screen.services.ServicesScreen
import com.example.oech_app.ui.screen.signup.SignUpScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    startScreen: String
) {
    NavHost(navController = navHostController, startDestination = startScreen) {
        composable(ScreensRouts.HomeScreen.route) {
            HomeScreen(navController = navHostController)
        }
        composable(ScreensRouts.SignUpScreen.route) {
            SignUpScreen(navController = navHostController, vm = koinViewModel())
        }
        composable(ScreensRouts.LogInScreen.route) {
            LogInScreen(navController = navHostController, vm = koinViewModel())
        }
        composable(ScreensRouts.MastersListScreen.route) {
            MastersList(navController = navHostController)
        }
        composable(
            route = "${ScreensRouts.MasterServicesScreen.route}/{name}/{count}/{phoneNumber}/{url}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("count") { type = NavType.StringType },
                navArgument("phoneNumber") { type = NavType.StringType },
                navArgument("url") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val count = backStackEntry.arguments?.getString("count") ?: ""
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            val url = Uri.decode(backStackEntry.arguments?.getString("url") ?: "")

            MasterServicesScreen(
                navController = navHostController,
                name = name,
                count = count,
                url = url,
                phoneNumber = phoneNumber
            )
        }
        composable(ScreensRouts.PromoScreen.route) {
            PromoScreen(navController = navHostController)
        }
        composable(ScreensRouts.ProfileScreen.route) {
            ProfileScreen(navController = navHostController)
        }
        composable(ScreensRouts.ServicesScreen.route) {
            ServicesScreen(navController = navHostController)
        }
    }
}