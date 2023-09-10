package com.example.hotelapp.domain

import androidx.lifecycle.LiveData

interface HotelRepository {
    fun getHoteResponce(): LiveData<HotelResponce>
    fun getHotelList(): LiveData<List<Hotels>>
    fun getHotel(): LiveData<Hotels>
}