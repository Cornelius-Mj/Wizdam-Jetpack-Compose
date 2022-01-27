package com.example.wizdam


import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wizdam.navigation.BottomNavGraph
import com.example.wizdam.navigation.NavItem
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination


@Composable
fun MainScreen() {
    val navMainCtrl = rememberNavController()
    Scaffold (
        bottomBar = { BottomBarNav(navController = navMainCtrl)}
    ){
        BottomNavGraph(navController = navMainCtrl)
    }
}

@Composable
fun BottomBarNav(navController: NavHostController) {
    val screens = listOf(
        NavItem.Article, NavItem.Community,
        NavItem.Post, NavItem.Notification, NavItem.Profile
    )
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStack?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(screen = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: NavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.key
        } == true,
        selectedContentColor = Color(0xFFEA4360),
        unselectedContentColor = Color.White,
        onClick = {
            navController.navigate(screen.key) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}