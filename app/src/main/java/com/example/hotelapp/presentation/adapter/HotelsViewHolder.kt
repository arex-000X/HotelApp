package com.example.hotelapp.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapp.R

class HotelsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val labelHotel = view.findViewById<TextView>(R.id.lable_hotel)
    val adressHotel = view.findViewById<TextView>(R.id.adress_hotel)
}