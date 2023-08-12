package com.example.core_data.mappers

abstract class Mapper<in I, out O>{
    abstract fun mapFrom(from: I): O
}