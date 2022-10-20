package com.elekse.gatewaylibrary

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import com.google.gson.Gson

class GatewayBuilder private constructor(
    val credentials: String?
) {

    data class Builder(
        var credentials: String? = null
    ) {

        fun credentials(credentials: String) = apply { this.credentials = credentials }
        fun build() = GatewayBuilder(credentials)
    }

    fun startPayment(activity: Activity, requestCode: Int, paymentRequestModel: PaymentRequestModel) {
        try {
            val intent = Intent("com.elekse.softpos.ui.main.listener.ListenerActivity")
            val gson = Gson()
            val json: String = gson.toJson(paymentRequestModel)
            intent.putExtra("paymentRequest",json)
            activity.startActivityForResult(intent, requestCode)
        } catch (ex: ActivityNotFoundException) {
            ex.printStackTrace()
            Log.e("Main", "Second application is not installed!")
        }
    }

}