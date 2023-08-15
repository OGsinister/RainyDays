package com.example.core_data.utils

val cityMap = mapOf(
    "Nizhnevartovsk" to "Нижневартовск",
    "Kazan" to "Казань",
    "Ufa" to "Уфа",
    "Moscow" to "Москва",
    "Saint Peterburg" to "Санкт-Петербург",
    "Orenburg" to "Оренбург",
    "Perm" to "Пермь",
    "Novosibirsk" to "Новосибирск"
)

fun TranslateCity(city: String): String{
    return cityMap.getOrDefault(city,city)
}