package com.example.mad_24172022034_assignment.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mad_24172022034_assignment.screen.ChatScreen
import com.example.mad_24172022034_assignment.screen.Splashscreen // Maan lijiye ki SplashScreen yahan hai

object Destination {
    const val SPLASH = "splash_screen"
    const val CHAT = "chat_screen"
}

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destination.SPLASH
    ) {
        composable(Destination.SPLASH) {
            Splashscreen(
                onNavigateToChat = {
                    navController.navigate(Destination.CHAT) {
                        popUpTo(Destination.SPLASH) { inclusive = true }
                    }
                }
            )
        }

    }
}