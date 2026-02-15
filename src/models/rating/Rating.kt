package models.rating

data class Rating(
    val userId: String,
    val contentId: String,
    val stars: Int,
    val review: String?,
    val timestamp: Long = System.currentTimeMillis(),
) {
    private var helpful: Int = 0
    fun isValid(): Boolean {
        return stars in 1..5
    }

    fun markAsHelpful() {
        ++helpful
    }

    fun getStarsAsText(): String {
        return "⭐".repeat(stars)
    }

    fun hasReview(): Boolean {
        return !review.isNullOrBlank()
    }

    fun getFormattedDate(): String {
        val date = java.util.Date(timestamp)
        val format = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale("ar"))
        return format.format(date)
    }

    override fun toString(): String {
        return buildString {
            append("Rating(")
            append("UserId=' $userId ' ,")
            append("Stars= $stars ${getStarsAsText()} ,")
            if (hasReview()) {
                append("Review= '$review' ,")
            }
            append("Helpful= $helpful ,")
            append("Date= ${getFormattedDate()} ")
            append(")")
        }
    }

}
