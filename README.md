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

