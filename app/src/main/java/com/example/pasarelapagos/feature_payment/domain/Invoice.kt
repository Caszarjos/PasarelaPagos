package com.example.pasarelapagos.feature_payment.domain

data class Invoice (
    val productName: String,
    val total: String,
    val invoiceId: String,
    val paymentMethod: String
)