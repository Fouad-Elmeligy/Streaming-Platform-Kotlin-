package models.user

import models.content.Content

abstract class User(userName: String, userEmail: String, userPassword: String) : Subscriber {
    init {
        if (!isValidEmail(userEmail)) {
            throw emailException()
        }
        if (!validPassword(userPassword)) {
            throw passwordException()
        }
    }

    private var name: String = userName
    private var email: String = userEmail
    private var password: String = hashPassword(userPassword)
    private val id: String = generateId()
    private val createdAt: Long = System.currentTimeMillis()

    protected var subscription: SubscriptionPlan = SubscriptionPlan.FREE
    protected val watchlist: MutableList<Content> = mutableListOf()
    protected val _watchHistory: MutableList<Content> = mutableListOf()
    protected val continueWatching: MutableMap<String, Int> = mutableMapOf()

    private fun generateId(): String {
        return "user_${System.currentTimeMillis()}_${(1000..9999).random()}"
    }

    fun getId(): String {
        if (!checkPermission())
            return "Please LogIn"
        return id
    }

    fun getCreatedAt(): Long {
        if (!checkPermission()) {
            println("Please Login first")
            return 0
        }
        return createdAt
    }

    fun getName(): String {
        if (!checkPermission())
            return "Please LogIn"
        return name
    }

    fun getEmail(): String {
        if (!checkPermission())
            return "Please LogIn"
        return email
    }





    fun updateName(newName: String) {
        require(newName.isNotBlank())
        email = newName
    }


    // Email Functions
    fun updateEmail(newEmail: String) {
        email = validEmail(newEmail)
    }

    private fun validEmail(email: String): String {
        require(isValidEmail(email))
        return email
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return email.matches(emailRegex)
    }


    // Password Functions
    fun updatePassword(newPass: String) {
        if (!validPassword(newPass)) {
            throw passwordException()
        }

        password = hashPassword(newPass)
    }

    private fun validPassword(password: String): Boolean {
        if (password.length < 7) {
            println("Password must be more than 7 from letters and digit")
            return false
        }
        if (!password.any { it.isDigit() }) {
            println("Password must have at least one Digit ")
            return false
        }
        if (!password.any { it.isLetter() }) {
            println("Password must have at least one Letter ")
            return false
        }
        return true


    }

    private fun hashPassword(password: String): String {
        // محاكاة تشفير بسيط (للتوضيح فقط!)
        // في الواقع: استخدم مكتبة تشفير قوية
        return password.hashCode().toString()
    }

    fun verifyPassword(inputPassword: String): Boolean {
        return hashPassword(inputPassword) == password
    }


    // Email and Password Exceptions
    private fun emailException(): Nothing {
        val emailException = Exception("This Email Not Valid")
        throw emailException
    }

    private fun passwordException(): Nothing {
        val passException = Exception("This Password Not Valid")
        throw passException
    }

    private fun checkPermission(): Boolean {
        val currentUser = SessionManager.getCurrentUser()

        return currentUser is Admin || currentUser?.id == this.id

    }


    // WATCHLIST MANAGEMENT
    // WATCHLIST
    fun getWatchList(): List<Content> {
          if (!checkPermission()) {
              println("Please Login First")
               return emptyList()
          }
         return watchlist.toList()
        }
    fun addToWatchlist(content: Content): Boolean {
        if (!checkPermission())
            throw Exception("Please Login First")

        if (watchlist.any { it.id == content.id }) {
            println("⚠\uFE0F ${content.title} -> Already on the watchlist ")
            return false
        }
        watchlist.add(content)
        println("✅ ${content.title} -> The content has been added to your watch list")
        return true
    }

    fun removeFromWatchlist(contentId: String): Boolean {
        if (!checkPermission())
            throw Exception("Please Login First")
        val content = watchlist.find { it.id == contentId }
        if (content ==null){
            println("⚠️ Content not found in the list")
            return false
        }
        watchlist.remove(content)
        println("✅ ${content.title} has been removed from the watchlist")
        return true
    }

    fun clearWatchlist(){
        if (!checkPermission())
            throw Exception("Please Login First")
        watchlist.clear()
        println("The watchlist has been cleared")

    }

    // WATCH HISTORY
    fun addToHistory(content: Content){
        if (!checkPermission())
            throw Exception("Please Login First")

        _watchHistory.removeIf { it.id==content.id }

        _watchHistory.add(0,content)

        if (_watchHistory.size > 50)
            _watchHistory.removeAt(_watchHistory.lastIndex)

    }

    fun clearHistory(){

        if (!checkPermission())
            throw Exception("Please Login First")

        _watchHistory.clear()
    }

    //CONTINUE WATCHING
    fun updateWatchProgress(contentId: String,timeInSeconds: Int){
        if (!checkPermission())
            throw Exception("Please Login First")
        require(timeInSeconds >= 0)

        continueWatching[contentId] = timeInSeconds

        println("⏱️ Progress updated: $timeInSeconds")
    }

    fun getWatchProgress(contentId: String): Int? {
        if (!checkPermission())
            throw Exception("Please Login First")

        return continueWatching[contentId]
    }

    fun clearWatchProgress(contentId: String) {
        if (!checkPermission())
            throw Exception("Please Login First")

        continueWatching.remove(contentId)
        println("🗑️ has been removed from the watchProgress ")
    }

    fun getWatchHistory(): List<Content> {
        if (!checkPermission()) {
            println("Please Login First")
            return emptyList()
        }
        return _watchHistory.toList()
    }

    fun getContinueWatchingList(): Map<String, Int> {
        if (!checkPermission())
            throw Exception("Please Login First")

        return continueWatching.toMap()
    }

    fun getProfile(): String {
        val date = java.util.Date(createdAt)
        val format = java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale("ar"))

        return buildString {
            append("👤 معلومات المستخدم\n")
            append("━".repeat(40) + "\n")
            append("الاسم: $name\n")
            append("البريد: $email\n")
            append("الاشتراك: $subscription\n")
            append("تاريخ التسجيل: ${format.format(date)}\n")
            append("قائمة المشاهدة: ${watchlist.size} عنصر\n")
            append("السجل: ${_watchHistory.size} عنصر\n")
            append("أكمل المشاهدة: ${continueWatching.size} عنصر")
        }
    }
    override fun toString(): String {
        return "User(id='$id', name='$name', email='$email', subscription=$subscription)"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}