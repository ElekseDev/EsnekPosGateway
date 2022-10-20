# EsnekPosGateway

Implementation


	repositories {
			...
		maven   { 
			
			url 'https://jitpack.io' 
	
			}
		}
		

Usage For Kotlin:

Create data class for payment request

	data class PaymentRequestModel(
    	var requestType: Int,
    	var amount: Double,
    	var installment: Int,
    	var paymentId: Int,
	)


Add global instance

	lateinit var gatewayBuilder: GatewayBuilder
	
Initialize the instance
	
	gatewayBuilder = GatewayBuilder.Builder()
            .build()
	    
	    
Start Payment Request
	
	//request Type must be 0 for starting payment
	val startPaymentRequestModel = PaymentRequestModel("requestType", "amount", "installment", "paymentId")
        gatewayBuilder.startPayment("activity", "requestCode", startPaymentRequestModel)

Logging Responses

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == "requestCode") {
            if (resultCode == RESULT_OK) {
	    	// if result is success
                val intentData = data?.getStringExtra("response")
            } else {
	    	// if result is unsuccessful
                val intentData = data?.getStringExtra("response")
                Toast.makeText(this, intentData, Toast.LENGTH_LONG).show()
            }
        }
    }
