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
    private fun validateCardNumber(): Boolean{
        //Remove spaces and dashes
        val cleanCardNumber=cardNumber.replace(Regex("[ -]"),"")

        //Check that the number contains only numbers
        if (!cleanCardNumber.matches(Regex("\\d+")))
            return false

        if (cleanCardNumber.length !in 13..19)
            return false

    }
    fun luhnCheck(cardNumber: String): Boolean{

    }
}