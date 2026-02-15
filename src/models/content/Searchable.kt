package models.content

interface Searchable {
    fun matchesKeyword(keyword: String): Boolean
    fun matchesGenre(genre: Genre): Boolean
    fun matchesYear(year: Int): Boolean
}