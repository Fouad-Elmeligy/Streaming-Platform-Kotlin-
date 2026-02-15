package models.user

object SessionManager {
    private var currentUser: User? = null

    fun login(user: User) {
        currentUser = user
        println("Login Success for => ${user.getName()}")
    }

    fun logout() {
        println("Logout Success for => ${currentUser?.getName()} ")
        currentUser = null
    }

    fun getCurrentUser(): User? = currentUser
    fun isLoggedIn(): Boolean = currentUser != null
    fun isAdmin(): Boolean = currentUser is Admin
}