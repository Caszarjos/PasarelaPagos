package com.example.pasarelapagos.feature_payment.ui

import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pasarelapagos.feature_payment.domain.Card
import com.example.pasarelapagos.feature_payment.domain.Invoice
import com.example.pasarelapagos.shared.inputtextfield.InputTextField_Payment
import com.example.pasarelapagos.shared.topappbar.PrevNextTopAppBar

@Composable
fun PaymentMastercardMethodScreen(
    callback: (MutableState<Invoice>) -> Unit,
    navigateTo: () -> Unit,
    invoiceInfo: MutableState<Invoice>
) {
    val cardNumber = remember { mutableStateOf("") }
    val expirationDate = remember { mutableStateOf("") }
    val cvv = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val country = remember { mutableStateOf("") }
    val city = remember { mutableStateOf("") }
    val postalCode = remember { mutableStateOf("") }

    /*
    val card = remember {
        mutableStateOf(Card(
            cardNumber.value, expirationDate.value,
            cvv.value, name.value,
            address.value, country.value,
            city.value, postalCode.value
        ))
    }*/

    val invoice = remember {
        mutableStateOf(Invoice(
            productName = invoiceInfo.value.productName,
            total = invoiceInfo.value.total,
            invoiceId = "",
            paymentMethod = "mastercard")
        )
    }

    /* TODO Peticion a proveedores de terceros para validar la tarjeta
    * LaunchedEffect(cardNumber.value, expirationDate.value, cvv.value, name.value, address.value, country.value, city.value, postalCode.value) {
        card.value = Card(
            cardNumber = cardNumber.value,
            expirationDate = expirationDate.value,
            cvv = cvv.value,
            name = name.value,
            address = address.value,
            country = country.value,
            city = city.value,
            postalCode = postalCode.value
        )
    }*/

    Scaffold(
        topBar = {
            PrevNextTopAppBar("Checkout")
        },
        bottomBar = { BottomConfirmComponent { onPressedButtonConfirm(callback, navigateTo, invoice) } }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(25.dp, 0.dp)
        ) {
            MastercardFormComponent(
                cardNumber, expirationDate,
                cvv, name,
                address, country,
                city, postalCode
            )
        }
    }
}

@Composable
fun MastercardFormComponent(
    cardNumber: MutableState<String>,
    expirationDate: MutableState<String>,
    cvv: MutableState<String>,
    name: MutableState<String>,
    address: MutableState<String>,
    country: MutableState<String>,
    city: MutableState<String>,
    postalCode: MutableState<String>
    ) {

    Text(
        text = "Payment Method Visa",
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        modifier = Modifier.paddingFromBaseline(0.dp, 40.dp))
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Mastercard", textAlign = TextAlign.Center)
        InputTextField_Payment(input = cardNumber, placeholder = "Card Number")
        Divider(modifier = Modifier.padding(5.dp))
        Row {
            InputTextField_Payment(
                input = expirationDate,
                placeholder = "Expiration Date",
                modifier = Modifier.width(200.dp))
            Spacer(modifier = Modifier.padding(5.dp))
            InputTextField_Payment(
                input = cvv,
                placeholder = "CVV",
                modifier = Modifier.width(150.dp))
        }
        Divider(modifier = Modifier.padding(5.dp))
        InputTextField_Payment(input = name, placeholder = "Name")
        Divider(modifier = Modifier.padding(5.dp))
        InputTextField_Payment(input = address, placeholder = "Address")
        Divider(modifier = Modifier.padding(5.dp))
        InputTextField_Payment(input = country, placeholder = "Country")
        Divider(modifier = Modifier.padding(5.dp))
        InputTextField_Payment(input = city, placeholder = "City")
        Divider(modifier = Modifier.padding(5.dp))
        InputTextField_Payment(input = postalCode, placeholder = "Postal Code")
    }

}
