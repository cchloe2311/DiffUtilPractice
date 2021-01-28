package com.example.diffutilpractice

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilpractice.model.HourlyWeatherModel

class HourlyWeatherDiffItemCallback : DiffUtil.ItemCallback<HourlyWeatherModel>() {
    override fun areItemsTheSame(
        oldItem: HourlyWeatherModel,
        newItem: HourlyWeatherModel
    ): Boolean = (oldItem === newItem)

    override fun areContentsTheSame(
        oldItem: HourlyWeatherModel,
        newItem: HourlyWeatherModel
    ): Boolean = (oldItem == newItem)
}