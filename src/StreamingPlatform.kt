import models.rating.Rating

fun main() {
  val timestamp: Long = System.currentTimeMillis()

  val day = java.util.Calendar.getInstance().apply {
    timeInMillis = timestamp
  }.get(java.util.Calendar.DAY_OF_MONTH)

  println(day) // Int

}