package com.example.pasarelapagos.feature_home.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pasarelapagos.feature_payment.domain.Order
import com.example.pasarelapagos.feature_payment.ui.InvoiceScreen
import com.example.pasarelapagos.feature_payment.ui.PaymentMastercardMethodScreen
import com.example.pasarelapagos.feature_payment.ui.PaymentMethodScreen
import com.example.pasarelapagos.feature_payment.ui.PaymentSummaryScreen
import com.example.pasarelapagos.feature_payment.ui.PaymentVisaMethodScreen

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val order = remember {
        mutableStateOf<Order>(Order(
            title = "The Crimson Beauty",
            description = "The Crimson Beauty is a stunning flowering plant known for its vibrant red flowers and glossy green leaves",
            quantity = "10000",
            unitPrice = "23"
        ))
    }

    NavHost(navController = navController, startDestination = Routes.PaymentMethod.route) {
        composable(Routes.PaymentSummary.route) {
            PaymentSummaryScreen(order) {
                navController.navigate(Routes.PaymentMethod.route)
            }
        }
        composable(Routes.PaymentMethod.route) {
            PaymentMethodScreen(
                toMastercardMethod = { navController.navigate(Routes.PaymentMethod.MastercardMethod.route) },
                toVisaMethod = { navController.navigate(Routes.PaymentMethod.VisaMethod.route) }
            )
        }
        composable(Routes.PaymentMethod.MastercardMethod.route) {
            PaymentMastercardMethodScreen()
        }
        composable(Routes.PaymentMethod.VisaMethod.route) {
            PaymentVisaMethodScreen()
        }
        composable(Routes.Invoice.route){
            InvoiceScreen()
        }
    }
}

sealed class Routes(val route: String) {
    data object PaymentSummary: Routes("PaymentSummary")
    data object PaymentMethod: Routes("PaymentMethod") {
        data object VisaMethod: Routes ("VisaMethod")
        data object MastercardMethod: Routes ("MastercardMethod")
    }
    data object Invoice: Routes("Payment")
}