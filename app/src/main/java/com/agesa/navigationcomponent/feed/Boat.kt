package com.agesa.navigationcomponent.feed

import com.agesa.navigationcomponent.R

class Boat(
    val id: Int,
    val name: String,
    val location: String,
    val picture: Int,
    val price: String
)

val BOATS = listOf(
    Boat(
        id = 1,
        name = "Canoe",
        location = "Tenerife",
        picture = R.drawable.boat,
        price = "45 EUR"

    ),
    Boat(
        id = 2,
        name = "Sailboat",
        location = "Costa Brava",
        picture = R.drawable.boat,
        price = "99 EUR"

    ),
    Boat(
        id = 3,
        name = "Kayak",
        location = "Mallorca",
        picture = R.drawable.boat,
        price = "120 EUR"
    )
)

fun List<Boat>.getBoat(id: Int) = find { it.id == id } ?: error("Boat Not Found")