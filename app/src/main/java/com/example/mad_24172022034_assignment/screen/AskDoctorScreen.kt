package com.example.mad_24172022034_assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_24172022034_assignment.componentes.AppHeader
import com.example.mad_24172022034_assignment.componentes.BottomNavigationBar

@Composable
fun DoctorScreen(
    onNavigateToChat: () -> Unit = {},
    onNavigateToTips: () -> Unit = {},
    onNavigateToDoctor: () -> Unit = {},
    onNavigateToHelp: () -> Unit = {}
) {
    var questionText by remember { mutableStateOf(TextFieldValue("")) }
    var isSubmitting by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            AppHeader("Ask a Doctor")

            Spacer(modifier = Modifier.height(8.dp))

            // Description text
            Text(
                text = "Submit your health-related questions to our team of verified healthcare professionals. We'll get back to you within 24 hours.",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Text field for question
            OutlinedTextField(
                value = questionText,
                onValueChange = { questionText = it },
                placeholder = { Text("Type your question here...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Submit button
            Button(
                onClick = {
                    if (questionText.text.isNotBlank()) {
                        isSubmitting = true
                        // TODO: connect to backend / Gemini API if needed
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (isSubmitting) "Submitting..." else "Submit Question",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        // Bottom Navigation
        BottomNavigationBar(
            selectedScreen = "Doctor",
            onTabSelected = { selected ->
                when (selected) {
                    "Chat" -> onNavigateToChat()
                    "Tips" -> onNavigateToTips()
                    "Doctor" -> onNavigateToDoctor()
                    "Help" -> onNavigateToHelp()
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DoctorScreenPreview() {
    DoctorScreen()
}
