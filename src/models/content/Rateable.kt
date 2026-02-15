package models.content

import models.rating.Rating

interface Rateable {
    fun addRating(rating: Rating)
    fun getAvgRating():Double
    fun getTotalRatings(): Int
}