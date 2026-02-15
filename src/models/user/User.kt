package models.user

 abstract class User(private var name: String,private var email: String,private var password: String): Subscriber{

    private val id: String = generateId()
    private val createdAt: Long= System.currentTimeMillis()

fun generateId(): String{
    return "user_${System.currentTimeMillis()}_${(1000..9999).random()}"
}

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