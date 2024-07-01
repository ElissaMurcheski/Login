package com.example.mylogin.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private fun isSelected(currentDestination: NavDestination?, route: String): Boolean {
    return currentDestination?.hierarchy?.any { it.route == route } == true
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.value?.destination

        BottomNavigation {
            BottomNavigationItem(selected = isSelected(currentDestination, "home"),
                onClick = { navController.navigate("home") },
                icon = {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Principal")
                })

            BottomNavigationItem(selected = isSelected(currentDestination, "trip"),
                onClick = { navController.navigate("trip") },
                icon = {
                    Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "Viagem")
                })

            BottomNavigationItem(selected = isSelected(currentDestination, "about"),
                onClick = { navController.navigate("about") },
                icon = {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Sobre")
                })
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {
            NavHost(navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(navController);
                }
                composable("trip") {
                    TripScreen(navController)
                }
                composable("about") {
                    AboutScreen(navController)
                }
                composable("tripForm") {
                    TripFormScreen(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}