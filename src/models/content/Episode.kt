package models.content

data class Episode(
    val episodeNumber: Int,
    val seasonNumber: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val releaseDate: Long
)
