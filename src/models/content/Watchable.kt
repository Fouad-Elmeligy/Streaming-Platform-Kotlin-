package models.content

interface Watchable {
    fun play(): String
    fun pause()
    fun stop()
    fun getDuration(): Int
}