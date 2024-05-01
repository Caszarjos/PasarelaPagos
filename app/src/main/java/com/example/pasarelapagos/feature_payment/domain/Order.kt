package com.example.pasarelapagos.feature_payment.domain

data class Order (
    val title: String,
    val description: String,
    val quantity: String,
    val unitPrice: String,
    var total: String
)