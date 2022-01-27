package com.example.wizdam.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(
    var key: String,
    var icon: ImageVector,
    var title: String
    ) {
            object Article : NavItem (
                key = "article",
                icon = Icons.Filled.Article,
                title = "Article"
            )
            object Community : NavItem (
                key = "group",
                icon = Icons.Filled.Group,
                title = "Group"
            )
            object Post : NavItem (
                key = "post",
                icon = Icons.Filled.PostAdd,
                title = "Post"
            )
            object Notification : NavItem (
                key = "notif",
                icon = Icons.Filled.Notifications,
                title = "Notif"
            )
            object Profile : NavItem (
                key = "profile",
                icon = Icons.Filled.Person,
                title = "Profile"
            )
}
