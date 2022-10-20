# EsnekPosGateway

Implementation


	repositories {
			...
		maven   { 
			
			url 'https://jitpack.io' 
	
			}
		}
		

Usage For Kotlin:


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
	val intentData = data?.getStringExtra("response")
            if (resultCode == RESULT_OK) {
	    	// if result is success
		Toast.makeText(this, intentData, Toast.LENGTH_LONG).show()
            } else {
	    	// if result is unsuccessful
                Toast.makeText(this, intentData, Toast.LENGTH_LONG).show()
            }
        }
    }
    
Usage For Java:


Add global instance

	GatewayBuilder gatewayBuilder;
	
Initialize the instance
	
	gatewayBuilder = new GatewayBuilder.Builder().build();
	    
	    
Start Payment Request
	
	//request Type must be 0 for starting payment
	PaymentRequestModel paymentRequestModel = new PaymentRequestModel("requestType", "amount", "installment", "paymentId");
        gatewayBuilder.startPayment("activity", "requestCode", startPaymentRequestModel);

Logging Responses

	@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == "requestCode") {
            String intentData = data != null ? data.getStringExtra("response") : "";
            if (resultCode == RESULT_OK) {
                // if result is success
                Toast.makeText(this, intentData, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, intentData, Toast.LENGTH_LONG).show();
            }
        }
    }
