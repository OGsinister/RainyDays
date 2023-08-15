package com.example.core_network.utils

sealed class Lang{
    data class Ru(val lang: String = "ru"): Lang()
    data class En(val lang: String = "en"): Lang()
}
