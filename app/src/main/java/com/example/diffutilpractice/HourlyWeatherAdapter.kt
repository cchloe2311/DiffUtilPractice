package com.example.diffutilpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilpractice.model.HourlyWeatherModel
import kotlinx.android.synthetic.main.item_hourly_weather.view.*

class HourlyWeatherAdapter (
    private val hourlyWeatherList: ArrayList<HourlyWeatherModel>
) : RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder =
        HourlyWeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hourly_weather, parent, false))

    override fun getItemCount(): Int = hourlyWeatherList.size

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(hourlyWeatherList[position])
    }

    fun changeList(newHourlyWeatherList: ArrayList<HourlyWeatherModel>) {
        val diffCallback = HourlyWeatherDiffCallback(hourlyWeatherList, newHourlyWeatherList)
        val diffResult = DiffUtil.calculateDiff(diffCallback) // 내부적으로 알고리즘을 써 변경된 아이템을 감지

        hourlyWeatherList.clear()
        hourlyWeatherList.addAll(newHourlyWeatherList)

        diffResult.dispatchUpdatesTo(this) // 업데이트 이벤트를 전달
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