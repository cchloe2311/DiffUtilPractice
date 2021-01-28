package com.example.diffutilpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.diffutilpractice.model.HourlyWeatherModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var hourlyWeatherList: ArrayList<HourlyWeatherModel> = arrayListOf(
        HourlyWeatherModel(9, "rain", 0),
        HourlyWeatherModel(10, "snow", 0),
        HourlyWeatherModel(11, "snow", 1),
        HourlyWeatherModel(12, "clear sky", 4),
        HourlyWeatherModel(13, "rain", -1)
    )
    val adapter = HourlyWeatherAdapter(hourlyWeatherList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_hourlyWeather.adapter = adapter
    }

    fun addNewItem(view: View) {
        val newHourlyWeatherList = ArrayList<HourlyWeatherModel>().apply {
            addAll(hourlyWeatherList)
            add(HourlyWeatherModel(14, "added item", 99))
        }

        adapter.changeList(newHourlyWeatherList)
        hourlyWeatherList = newHourlyWeatherList
    }
}
