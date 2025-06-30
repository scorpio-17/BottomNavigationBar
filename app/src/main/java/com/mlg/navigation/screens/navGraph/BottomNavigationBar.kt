package com.mlg.navigation.screens.navGraph

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mlg.navigation.R
import com.mlg.navigation.Screen


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val selectedIndex = remember { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = colorResource(R.color.white)
    ) {
        pages.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = selectedIndex.intValue == index,
                icon = {
                    Icon(
                        navigationItem.icon, navigationItem.title,
                        tint = if (selectedIndex.intValue == index) colorResource(R.color.white) else colorResource(
                            R.color.gray
                        )
                    )
                },
                onClick = {
                    selectedIndex.intValue = index
                    navController.navigate(navigationItem.screenRoute)
                },
                label = {
                    Text(
                        text = navigationItem.title,
                        color = if (selectedIndex.intValue == index) colorResource(R.color.black) else colorResource(
                            R.color.gray
                        )
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(R.color.white),
                    indicatorColor = colorResource(R.color.reddish)
                )
            )
        }
    }

}

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screenRoute: String
)

val pages = listOf(
    NavigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        screenRoute = Screen.Home.route
    ),
    NavigationItem(
        title = "Profile",
        icon = Icons.Default.Person,
        screenRoute = Screen.Profile.route
    ),
    NavigationItem(
        title = "Cart",
        icon = Icons.Default.ShoppingCart,
        screenRoute = Screen.Cart.route
    ),
    NavigationItem(
        title = "Setting",
        icon = Icons.Default.Settings,
        screenRoute = Screen.Setting.route
    )
)