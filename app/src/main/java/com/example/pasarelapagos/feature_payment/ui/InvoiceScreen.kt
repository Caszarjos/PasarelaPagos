package com.example.pasarelapagos.feature_payment.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pasarelapagos.feature_payment.domain.Card
import com.example.pasarelapagos.feature_payment.domain.Invoice
import com.example.pasarelapagos.shared.topappbar.PrevNextTopAppBar

@Composable
fun InvoiceScreen(
    invoice: MutableState<Invoice>
) {
    Scaffold(
        topBar = {
            PrevNextTopAppBar("Checkout")
        },
        bottomBar = { ExitComponent() }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(25.dp, 0.dp)
        ) {
            InvoiceComponent(invoice)
        }
    }
}

@Composable
fun InvoiceComponent(invoice: MutableState<Invoice>) {
    Text(
        text = "Invoice",
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.paddingFromBaseline(0.dp, 40.dp))
    Scaffold(
        topBar = {
            Text(text = "20 Nov 2024 - 18:34")
        }
    ) { paddingValues ->
        Card(modifier = Modifier.padding(paddingValues).padding()) {
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp, 15.dp, 0.dp, 0.dp)
            ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = "favorite")
                Text(text = "Transaction succeed")
            }
            Divider(modifier = Modifier.padding(15.dp))
            Text(text = "Product", modifier = Modifier.padding(10.dp, 5.dp))
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp, 0.dp, 10.dp, 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = invoice.value.productName)
                Text(text = invoice.value.total)
            }
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Invoice id")
                Text(text = "20241120-001")
            }
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Payment Method")
                Text(text = invoice.value.paymentMethod)
            }
            Row (
                modifier = Modifier.fillMaxWidth().padding(10.dp, 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total", fontSize = 20.sp)
                Text(text = "23,000$", fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun ExitComponent() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { /*TODO NAVIGATE TO PRODUCTS*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp)) {
            Text(text = "See more products")
        }
    }

}