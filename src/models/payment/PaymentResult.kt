package models.payment

sealed class PaymentResult {
    data class Success(val transactionId: String,val amount: Double,val timestamp: Long): PaymentResult()
    data class Failed(val reason: String,val errorCode: Int): PaymentResult()
    object Pending: PaymentResult()
    object Cancelled: PaymentResult()
}