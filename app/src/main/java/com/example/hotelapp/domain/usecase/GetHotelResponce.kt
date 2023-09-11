package com.example.hotelapp.domain.usecase

import com.example.hotelapp.data.repository.HotelRepositoryImpl
import com.example.hotelapp.domain.repository.HotelRepository

class GetHotelResponce(private val repository: HotelRepository) {
    fun getHotelResponce(repository: HotelRepositoryImpl) =  this.repository.getHoteResponce()
    }
