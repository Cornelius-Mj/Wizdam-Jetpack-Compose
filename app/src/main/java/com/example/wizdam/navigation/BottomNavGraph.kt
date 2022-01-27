package com.example.wizdam.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wizdam.*


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Profile.key
    ) {
        composable(route = NavItem.Article.key){
            ArticlePage()
        }
        composable(route = NavItem.Community.key){
            CommunityPage()
        }
        composable(route = NavItem.Post.key) {
            PostPage()
        }
        composable(route = NavItem.Notification.key) {
            NotificationPage()
        }
        composable(route = NavItem.Profile.key) {
            ProfilePage()
        }
    }
}