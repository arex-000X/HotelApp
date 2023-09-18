package com.example.hotelapp.presentation.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapp.R
import com.example.hotelapp.domain.model.HotelResponce
import com.example.hotelapp.domain.model.Hotels
import com.google.gson.annotations.Until

class HotelsAdapter : RecyclerView.Adapter<HotelsAdapter.ViewHolder>() {

    var hotels: List<Hotels> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    var hotelItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = hotels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel: Hotels = hotels.get(position)
        holder.labelHotel.text = hotel.label
        holder.adressHotel.text = hotel.fullName
        holder.itemView.setOnClickListener {
            hotelItemClickListener?.invoke(hotel.id)
        }

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val labelHotel = view.findViewById<TextView>(R.id.lable_hotel)
        val adressHotel = view.findViewById<TextView>(R.id.adress_hotel)
    }
}