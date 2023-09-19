package com.example.hotelapp.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.hotelapp.R
import com.example.hotelapp.domain.model.Hotels

class HotelsAdapter : ListAdapter<Hotels,HotelsViewHolder>(DiffItemAdapter()) {

    var hotelItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  HotelsViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyler_item, parent, false)
        return  HotelsViewHolder(view)
    }
    override fun onBindViewHolder(holder:  HotelsViewHolder, position: Int) {
        val hotel: Hotels = getItem(position)
        holder.labelHotel.text = hotel.label
        holder.adressHotel.text = hotel.fullName
        holder.itemView.setOnClickListener {
            hotelItemClickListener?.invoke(hotel.id)
        }

    }
}