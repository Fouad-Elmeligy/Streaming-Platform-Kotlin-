package models.payment

class CashPayment: PaymentMethod {
    override fun processPayment(amount: Double): PaymentResult {
        TODO("Not yet implemented")
    }

    override fun getPaymentMethodName(): String {
        TODO("Not yet implemented")
    }

    override fun validatePaymentInfo(): Boolean {
        TODO("Not yet implemented")
    }
}