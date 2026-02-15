package models.user

class RegularUser(name: String,email: String,password: String): User(userName = name, userEmail = email,userPassword=password) {
    override fun subscribe(plan: SubscriptionPlan): Boolean {
        TODO("Not yet implemented")
    }

    override fun cancelSubscription(): Boolean {
        TODO("Not yet implemented")
    }

    override fun upgradeSubscription(newPlan: SubscriptionPlan): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSubscriptionsStatus(): SubscriptionPlan {
        TODO("Not yet implemented")
    }
}