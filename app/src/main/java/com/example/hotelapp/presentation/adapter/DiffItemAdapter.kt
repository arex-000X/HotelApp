package com.example.hotelapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hotelapp.domain.model.Hotels

class DiffItemAdapter: DiffUtil.ItemCallback<Hotels>() {
    override fun areItemsTheSame(oldItem: Hotels, newItem: Hotels): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Hotels, newItem: Hotels): Boolean {
        return oldItem.id == newItem.id
    }
}