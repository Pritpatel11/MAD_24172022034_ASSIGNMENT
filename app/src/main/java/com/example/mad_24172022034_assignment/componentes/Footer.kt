package com.example.mad_24172022034_assignment.componentes

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.mad_24172022034_assignment.R

@Composable
fun BottomNavigationBar(
    selectedScreen: String = "Chat", // Default to Chat screen
    onTabSelected: (String) -> Unit = {}
) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        NavigationBarItem(
            selected = selectedScreen == "Chat",
            onClick = { onTabSelected("Chat") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chat_24),
                    contentDescription = "Chat"
                )
            },
            label = { Text("Chat") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = selectedScreen == "Tips",
            onClick = { onTabSelected("Tips") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_lightbulb_24),
                    contentDescription = "Tips"
                )
            },
            label = { Text("Tips") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = selectedScreen == "Doctor",
            onClick = { onTabSelected("Doctor") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_contacts_product_24),
                    contentDescription = "Doctor"
                )
            },
            label = { Text("Doctor") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )

        NavigationBarItem(
            selected = selectedScreen == "Help",
            onClick = { onTabSelected("Help") },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_help_24),
                    contentDescription = "Help"
                )
            },
            label = { Text("Help") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray
            )
        )
    }
}
