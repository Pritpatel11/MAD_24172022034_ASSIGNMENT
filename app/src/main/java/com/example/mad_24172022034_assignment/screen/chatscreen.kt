package com.example.mad_24172022034_assignment.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_24172022034_assignment.api.GeminiService.getHealthResponse
import com.example.mad_24172022034_assignment.componentes.AppHeader
import com.example.mad_24172022034_assignment.componentes.BottomNavigationBar
import com.example.mad_24172022034_assignment.componentes.ChatMessageItem
import com.example.mad_24172022034_assignment.componentes.InputField
import kotlinx.coroutines.launch

// Data class for chat message
data class ChatMessageData(val message: String, val isUser: Boolean)

// --- Chat Screen ---
@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    var messages by remember {
        mutableStateOf(
            listOf(ChatMessageData("Hello! I am your Health Assistant 🤖", isUser = false))
        )
    }

    var inputText by remember { mutableStateOf(TextFieldValue("")) }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 5.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Messages list
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = false,
            verticalArrangement = Arrangement.Top
        ) {
            item { AppHeader("Health Assistant") }
            items(messages) { msg ->
                ChatMessageItem(msg)
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (isLoading) {
                item {
                    Text(
                        "Gemini is thinking...",
                        color = Color.Gray,
                        modifier = Modifier.padding(8.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }

        // Input Section
        InputField(
            text = inputText,
            onTextChange = { inputText = it },
            onSendClick = {
                if (inputText.text.isNotBlank() && !isLoading) {
                    val userMessage = ChatMessageData(inputText.text, isUser = true)
                    messages = messages + userMessage
                    val question = inputText.text
                    inputText = TextFieldValue("")
                    isLoading = true

                    coroutineScope.launch {
                        val reply = getHealthResponse(question)
                        Log.d("ChatScreen", "API Response: $reply")
                        messages = messages + ChatMessageData(reply, isUser = false)
                        isLoading = false
                    }
                }
            }
        )

        // Bottom Navigation
        BottomNavigationBar()

    }
}

@Preview(showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}
