package com.mlg.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.mlg.navigation.screens.CartScreen
import com.mlg.navigation.screens.HomeScreen
import com.mlg.navigation.screens.ProfileScreen
import com.mlg.navigation.screens.SettingScreen
import com.mlg.navigation.screens.navGraph.BottomNavigationBar
import com.mlg.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.white)),
        bottomBar = { BottomNavigationBar(navController) }) {
        val graph = navController.createGraph(startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable(Screen.Cart.route) { CartScreen() }
            composable(Screen.Setting.route) { SettingScreen() }
        }

        NavHost(navController = navController, graph = graph, modifier = Modifier.padding(it))
    }

}