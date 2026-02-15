package models.content

enum class ContentRating(private val minAge: Int, private val description: String) {


    G(
        minAge = 0,
        description = "جميع الأعمار"
    ),

    PG(
        minAge = 8,
        description = "بإشراف الوالدين"
    ),

    PG_13(
        minAge = 13,
        description = "فوق 13 سنة"
    ),

    R(
        minAge = 17,
        description = "محتوى للكبار"
    ),

    NC_17(
        minAge = 18,
        description = "+18 فقط"
    );

    fun getMinAge(): Int = minAge
    fun getDescription(): String = description
    fun isAppropriateForAge(age: Int): Boolean {
        return age >= minAge
    }
}