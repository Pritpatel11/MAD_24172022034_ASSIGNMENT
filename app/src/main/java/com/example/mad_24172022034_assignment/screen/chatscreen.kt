package com.example.mad_24172022034_assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mad_24172022034_assignment.componentes.AppHeader
import com.example.mad_24172022034_assignment.componentes.BottomNavigationBar
import com.example.mad_24172022034_assignment.componentes.ChatMessageItem
import com.example.mad_24172022034_assignment.componentes.InputField

// Data class for chat message
data class ChatMessageData(val message: String, val isUser: Boolean)

// --- Chat Screen ---
@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    var messages by remember {
        mutableStateOf(
            listOf(
                ChatMessageData("Hello! I am your ChatBot.", isUser = false),
                ChatMessageData("Hi! How are you?", isUser = true)
            )
        )
    }

    var inputText by remember { mutableStateOf(TextFieldValue("")) }

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
            item { AppHeader() }
            items(messages) { msg ->
                ChatMessageItem(msg)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Input Section
        InputField(
            text = inputText,
            onTextChange = { inputText = it },
            onSendClick = {
                if (inputText.text.isNotBlank()) {
                    messages = messages + ChatMessageData(inputText.text, isUser = true)
                    inputText = TextFieldValue("")
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
