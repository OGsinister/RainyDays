package com.example.core_data.utils

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}