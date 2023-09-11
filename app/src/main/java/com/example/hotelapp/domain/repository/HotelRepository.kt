package com.example.hotelapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.hotelapp.domain.HotelResponce
import com.example.hotelapp.domain.Hotels

interface HotelRepository {
    fun getHoteResponce(): LiveData<HotelResponce>
    fun getHotelList(): LiveData<List<Hotels>>
    fun getHotel():LiveData<HotelResponce>
}