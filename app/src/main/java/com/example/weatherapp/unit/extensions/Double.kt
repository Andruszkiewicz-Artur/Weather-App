package com.example.weatherapp.unit.extensions

fun Double.toDegree(): String {
    return "${if(this < 0) this else "+$this"}°"
}