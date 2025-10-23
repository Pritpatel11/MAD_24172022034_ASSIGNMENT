package com.example.mad_24172022034_assignment.api

import android.util.Log
import com.example.mad_24172022034_assignment.Constants
import com.google.ai.client.generativeai.GenerativeModel


object GeminiService {

    private const val GEMINI_API_KEY = Constants.apikey


    private val model = GenerativeModel(
        modelName = "gemini-2.5-flash",
        apiKey = GEMINI_API_KEY
    )

    suspend fun getHealthResponse(prompt: String): String {
        val lowerCasePrompt = prompt.trim().toLowerCase()

        if (lowerCasePrompt == "hi" || lowerCasePrompt == "hello" || lowerCasePrompt == "hey") {
            return "Hello! I am your Health Assistant 🤖. How can I help you with your health-related questions today?"
        }
        val refinedPrompt = """
            You are a health assistant chatbot.
            Answer ONLY health-related questions clearly and politely.
            If the question is not related to health, respond with:
            "I'm sorry, I can only help with health-related topics."
            
            User: $prompt
        """.trimIndent()
        Log.d("GeminiService", "Sending prompt to Gemini model: $refinedPrompt")
        return try {
            val response = model.generateContent(refinedPrompt)
            response.text ?: "Sorry, I couldn’t generate a response."
        } catch (e: Exception) {
            "Error: ${e.message}"
        }

    }
}

