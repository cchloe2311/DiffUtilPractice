package com.example.diffutilpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilpractice.model.HourlyWeatherModel
import kotlinx.android.synthetic.main.item_hourly_weather.view.*

class HourlyWeatherAdapter : ListAdapter<HourlyWeatherModel, HourlyWeatherAdapter.HourlyWeatherViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder =
        HourlyWeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hourly_weather, parent, false))

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun changeList(newHourlyWeatherList: ArrayList<HourlyWeatherModel>) {
        submitList(newHourlyWeatherList)
    }

    class HourlyWeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTime: TextView = view.tv_time
        private val tvDescription: TextView = view.tv_description
        private val tvTemperature: TextView = view.tv_temperature

        fun bind(hourlyWeather: HourlyWeatherModel) {
            tvTime.text = hourlyWeather.time.toString() + "시"
            tvDescription.text = hourlyWeather.description
            tvTemperature.text = hourlyWeather.temperature.toString() + "°C"
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<HourlyWeatherModel>() {
    override fun areItemsTheSame(
        oldItem: HourlyWeatherModel,
        newItem: HourlyWeatherModel
    ): Boolean = oldItem === newItem

    override fun areContentsTheSame(
        oldItem: HourlyWeatherModel,
        newItem: HourlyWeatherModel
    ): Boolean = oldItem == newItem

}