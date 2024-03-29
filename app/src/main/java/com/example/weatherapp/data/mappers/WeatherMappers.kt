package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.dto.weather.WeatherDto
import com.example.weatherapp.data.dto.weather.WeatherDataDto
import com.example.weatherapp.domain.model.remote.weather.WeatherDailyData
import com.example.weatherapp.domain.model.remote.weather.WeatherData
import com.example.weatherapp.domain.model.remote.weather.WeatherInfo
import com.example.weatherapp.domain.model.remote.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}

fun WeatherInfo.toWeatherDailyData(index: Int): WeatherDailyData {
    return WeatherDailyData(
        data = weatherDataPerDay.get(index)?.first()?.time,
        maxDegree = weatherDataPerDay.get(index)?.maxOf { it.temperatureCelsius },
        minDegree = weatherDataPerDay.get(index)?.minOf { it.temperatureCelsius },
        weatherType = weatherDataPerDay.get(index)?.get(11)?.weatherType,
        averageWindSpeed = weatherDataPerDay.get(index)?.let {
            var result: Double = 0.0

            it.forEach {
                result += it.windSpeed
            }

            result/it.size
        },
        averageHumidity = weatherDataPerDay.get(index)?.let {
            var result: Double = 0.0

            it.forEach {
                result += it.humidity
            }

            result/it.size
        },
        averagePressure = weatherDataPerDay.get(index)?.let {
            var result: Double = 0.0

            it.forEach {
                result += it.pressure
            }

            result/it.size
        }
    )
}