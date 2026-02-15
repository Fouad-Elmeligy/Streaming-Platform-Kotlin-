package search

import models.content.Genre
import models.rating.Rating

sealed class SearchFilter {
    data class ByGenre(val genre: Genre) : SearchFilter()

    data class ByYear(val year: Int) : SearchFilter()

    data class ByRating(val minRating: Double) : SearchFilter()

    data class ByTitle(val title: String) : SearchFilter()

    data class Combined(val filters: List<SearchFilter>) : SearchFilter()
}