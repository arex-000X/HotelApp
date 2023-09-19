package com.example.hotelapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.hotelapp.domain.model.HotelResponce
import com.example.hotelapp.domain.model.Hotels
import com.example.hotelapp.domain.model.Results

interface HotelRepository {
    fun getHotelList(): LiveData<List<Hotels>>
    fun getHotel(id:Int): LiveData<HotelResponce>
}