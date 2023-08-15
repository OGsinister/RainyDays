package com.example.core_network.utils

import android.annotation.SuppressLint
import java.util.Locale

@SuppressLint("SuspiciousIndentation")
fun LangSwitcher(currentLang: Locale): String{
    if(currentLang.language == "ru")
        return Lang.Ru().lang
    else (currentLang.language == "en")
        return Lang.En().lang
}
