package com.example.mad_24172022034_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mad_24172022034_assignment.ui.theme.MAD_24172022034_ASSIGNMENTTheme

import com.example.mad_24172022034_assignment.navigation.AppNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAD_24172022034_ASSIGNMENTTheme {

                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    paddingValues.calculateBottomPadding()
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}