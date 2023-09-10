package com.example.hotelapp.domain

import com.example.hotelapp.data.HotelRepositoryImpl

class GetHotelUseCase(private val repository: HotelRepository) {
    fun getHotel(repository: HotelRepositoryImpl) = repository.getHotel()
}