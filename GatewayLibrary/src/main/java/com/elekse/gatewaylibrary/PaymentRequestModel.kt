package com.elekse.gatewaylibrary

data class PaymentRequestModel(
    var requestType: Int,
    var amount: Double,
    var installment: Int,
    var paymentId: Int,
)
