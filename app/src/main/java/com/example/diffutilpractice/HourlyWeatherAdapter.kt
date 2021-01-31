package com.example.diffutilpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilpractice.model.HourlyWeatherModel
import kotlinx.android.synthetic.main.item_hourly_weather.view.*

class HourlyWeatherAdapter : RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherViewHolder>() {

    // 구현한 DiffUtil.ItemCallback<T>로 객체 생성 및 내부 currentList를 사용
    private val asyncDiffer = AsyncListDiffer(this, HourlyWeatherDiffItemCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder =
        HourlyWeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hourly_weather, parent, false))

    override fun getItemCount(): Int = asyncDiffer.currentList.size

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(asyncDiffer.currentList[position])
    }

    fun changeList(newHourlyWeatherList: ArrayList<HourlyWeatherModel>) {
        asyncDiffer.submitList(newHourlyWeatherList)
        /**
         * submitList 메소드의 역할
         * 1. 업데이트 해야 할 부분 확인
         * 2. newList로 recyclerview list를 업데이트 (Read-only라 해당 메소드로 업데이트 필요)
         */
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