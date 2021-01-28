package com.example.diffutilpractice

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilpractice.model.HourlyWeatherModel

class HourlyWeatherDiffCallback(
    private val oldList: ArrayList<HourlyWeatherModel>,
    private val newList: ArrayList<HourlyWeatherModel>
): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("diff-areItemsTheSame ", (oldList[oldItemPosition] === newList[newItemPosition]).toString())
        Log.d("diff-areItemsTheSame ", "oldPosition: $oldItemPosition")
        Log.d("diff-areItemsTheSame ", "newPosition: $newItemPosition")
        Log.d("diff-areItemsTheSame ", "-----------------------")

        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("diff-areContentsTheSame", (oldList[oldItemPosition] == newList[newItemPosition]).toString())
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}