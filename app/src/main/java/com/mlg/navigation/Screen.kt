package com.mlg.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Profile : Screen("profile_screen")
    data object Cart : Screen("cart_screen")
    data object Setting : Screen("setting_screen")
}