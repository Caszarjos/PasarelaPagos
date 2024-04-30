package com.example.pasarelapagos.feature_payment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pasarelapagos.shared.topappbar.PrevNextTopAppBar

@Composable
fun PaymentVisaMethodScreen () {
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
            VisaFormComponent()
        }
    }
}

@Composable
fun VisaFormComponent() {
    Text(
        text = "Payment Method",
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.paddingFromBaseline(0.dp, 40.dp))

}

@Composable
fun BottomConfirmComponent() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp)) {
            Text(text = "Confirm Payment")
        }
    }

}