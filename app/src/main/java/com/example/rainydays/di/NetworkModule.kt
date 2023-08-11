package com.example.rainydays.di

import com.example.core_network.WeatherApi
import com.example.core_network.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): WeatherApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideHttp() = OkHttpClient.Builder()
        .addInterceptor((HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }))
}