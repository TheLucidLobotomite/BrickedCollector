package com.example.legoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.legoapp.screens.MySetScreen
import com.example.legoapp.screens.WantListScreen
import com.example.legoapp.screens.BuyScreen
import com.example.legoapp.screens.SellScreen
import com.example.legoapp.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "my_sets"
    ) {
        composable("my_sets") {
            MySetScreen(
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }

        composable("want_list") {
            WantListScreen(
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }

        composable("buy") {
            BuyScreen(
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }

        composable("sell") {
            SellScreen(
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }

        composable("settings") {
            SettingsScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}