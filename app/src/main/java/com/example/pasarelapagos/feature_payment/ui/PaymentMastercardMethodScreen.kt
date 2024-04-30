package com.example.pasarelapagos.feature_payment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pasarelapagos.shared.topappbar.PrevNextTopAppBar

@Composable
fun PaymentMastercardMethodScreen() {
    Scaffold(
        topBar = {
            PrevNextTopAppBar("Checkout")
        },
        bottomBar = { BottomConfirmComponent() }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(25.dp, 0.dp)
        ) {
            MastercardFormComponent()
        }
    }
}

@Composable
fun MastercardFormComponent() {
    Text(
        text = "Payment Method",
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.paddingFromBaseline(0.dp, 40.dp))

}