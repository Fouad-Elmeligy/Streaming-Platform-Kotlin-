package models.user

data class SubscriptionInfo(
    val userId: String,
    var plan: SubscriptionPlan,
    val startDate: Long,
    val endDate: Long,
    var isActive: Boolean,
    var autoRenew: Boolean
) {
    fun isExpired(): Boolean {
        return System.currentTimeMillis() >= endDate
    }
    fun daysRemaining(): Int{
       val currentDay= System.currentTimeMillis()
        return java.util.Calendar.getInstance().apply {
            timeInMillis = endDate
        }.get(java.util.Calendar.DAY_OF_MONTH) - java.util.Calendar.getInstance().apply {
            timeInMillis = currentDay
        }.get(java.util.Calendar.DAY_OF_MONTH)
    }
}