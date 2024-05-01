package com.example.pasarelapagos.feature_payment.domain

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class Card (
    val cardNumber: String,
    val expirationDate: String,
    val cvv: String,
    val name: String,
    val address: String,
    val country: String,
    val city: String,
    val postalCode: String
)
