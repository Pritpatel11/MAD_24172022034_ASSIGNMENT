package com.example.mad_24172022034_assignment.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputField(
    text: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit,
    onSendClick: () -> Unit,
    placeholder: String = "Type a message"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Text input
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .weight(1f)
                .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(24.dp)),
            placeholder = { Text(placeholder) },
            singleLine = true
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Send button
        Button(
            onClick = onSendClick,
            shape = RoundedCornerShape(24.dp)
        ) {
            Text("Send")
        }
    }
}
