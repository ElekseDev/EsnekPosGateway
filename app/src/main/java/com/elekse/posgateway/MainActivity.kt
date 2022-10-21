package com.elekse.posgateway

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elekse.gatewaylibrary.GatewayBuilder
import com.elekse.gatewaylibrary.PaymentRequestModel

class MainActivity : AppCompatActivity() {

    var btnStartPayment: Button? = null
    lateinit var gatewayBuilder: GatewayBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartPayment = findViewById(R.id.btn_start_payment)

        gatewayBuilder = GatewayBuilder.Builder()
            //.credentials("Credentials")
            .build()

        btnStartPayment?.setOnClickListener {
            val startPaymentRequestModel = PaymentRequestModel(0, 1.0, 1)

            gatewayBuilder.startPayment(this, 100, startPaymentRequestModel)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                val intentData = data?.getStringExtra("response")
                println("Intent Data - $intentData")
            } else {
                val intentData = data?.getStringExtra("response")
                Toast.makeText(this, intentData, Toast.LENGTH_LONG).show()
            }
        }
    }

}