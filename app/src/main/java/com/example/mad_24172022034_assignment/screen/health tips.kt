package com.example.mad_24172022034_assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad_24172022034_assignment.R
import com.example.mad_24172022034_assignment.componentes.AppHeader
import com.example.mad_24172022034_assignment.componentes.BottomNavigationBar
import com.example.mad_24172022034_assignment.componentes.HealthTipCard

data class HealthTip(
    val title: String,
    val description: String,
    val category: String,
    val imageRes: Int
)

@Composable
fun HealthTipsScreen() {
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = listOf("All", "Nutrition", "Fitness", "Mental Health")

    val healthTips = listOf(
        HealthTip(
            "Understanding the Importance of Regular Check-ups",
            "Regular health check-ups are crucial for early detection and prevention of diseases. Learn more about what to expect during a check-up and how to prepare.",
            "General",
            R.drawable.doctor
        ),
        HealthTip(
            "Healthy Eating Habits for a Balanced Lifestyle",
            "Discover the basics of a balanced diet, including portion control and meal planning tips to support your overall health.",
            "Nutrition",
            R.drawable.food
        ),
        HealthTip(
            "Effective Stress Management Techniques",
            "Learn mindfulness, exercise, and relaxation strategies to improve your mental well-being.",
            "Mental Health",
            R.drawable.yoga
        ),
    )

    val filteredTips = if (selectedCategory == "All")
        healthTips
    else
        healthTips.filter { it.category == selectedCategory }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp)
    ) {
        // Header
        AppHeader("Health Tips")

        // Category Tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = { Text(category) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }


        // LazyColumn with HealthTipCard
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(filteredTips) { tip ->
                HealthTipCard(tip)
            }
        }
        BottomNavigationBar("Tips")
    }

}

@Preview(showSystemUi = true)
@Composable
fun HealthTipsScreenPreview() {
    HealthTipsScreen()
}
