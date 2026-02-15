package models.content

enum class Genre(val arabicName: String) {
    ACTION(arabicName = "أكشن"),
    COMEDY(arabicName ="كوميديا"),
    DRAMA(arabicName ="دراما"),
    HORROR(arabicName ="رعب"),
    ROMANCE(arabicName ="رومانسي"),
    SCI_FI(arabicName ="خيال علمي"),
    THRILLER(arabicName ="إثارة"),
    DOCUMENTARY(arabicName ="وثائقي"),
    ANIMATION(arabicName ="رسوم متحركة"),
    CRIME(arabicName ="جريمة");

    fun getarabicName(): String = arabicName
}