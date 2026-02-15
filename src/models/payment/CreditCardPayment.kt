package models.payment

class CreditCardPayment(
    private val cardNumber: String,
    private val cardHolder: String,
    private val expiryDate: String,
    private val cvv: String
) : PaymentMethod {
    override fun processPayment(amount: Double): PaymentResult {
        TODO("Not yet implemented")
    }

    override fun getPaymentMethodName(): String {
        TODO("Not yet implemented")
    }

    override fun validatePaymentInfo(): Boolean {
        TODO("Not yet implemented")
    }

    fun luhnCheck(cardNumber: String){

    }
}