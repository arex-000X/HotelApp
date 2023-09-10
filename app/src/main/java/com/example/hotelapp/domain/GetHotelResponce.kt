package com.example.hotelapp.domain

import com.example.hotelapp.data.HotelRepositoryImpl

class GetHotelResponce(private val repository: HotelRepository) {
    fun getHotelResponce(repository: HotelRepositoryImpl) =  this.repository.getHoteResponce()
    }
