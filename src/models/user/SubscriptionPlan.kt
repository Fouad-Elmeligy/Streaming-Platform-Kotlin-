package models.user

enum class SubscriptionPlan(val price: Double, val maxDevices: Int, val hasHD: Boolean, val has4K: Boolean) {
    FREE(price = 0.0, maxDevices = 1, hasHD = false, has4K = false),
    BASIC(price = 9.99, maxDevices = 1, hasHD = true, has4K = false),
    STANDARD(price = 14.99, maxDevices = 2, hasHD = true, has4K = false),
    PREMIUM(price = 19.99, maxDevices = 4, hasHD = true, has4K = true);

    fun getSubscriptionPlanPrice(): Double = price
    fun getMaxDevice(): Int = maxDevices
    fun hasHD(): Boolean = hasHD
    fun has4K(): Boolean = has4K
}