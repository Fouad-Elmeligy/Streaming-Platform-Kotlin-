package models.payment

interface PaymentMethod {
    fun processPayment(amount: Double): PaymentResult
    fun getPaymentMethodName(): String
    fun validatePaymentInfo(): Boolean
}