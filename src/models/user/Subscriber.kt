package models.user

interface Subscriber {
    fun subscribe(plan: SubscriptionPlan): Boolean
    fun cancelSubscription(): Boolean
    fun upgradeSubscription(newPlan: SubscriptionPlan): Boolean
    fun getSubscriptionsStatus(): SubscriptionPlan
}