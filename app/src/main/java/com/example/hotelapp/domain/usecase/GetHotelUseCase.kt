package com.example.hotelapp.domain.usecase

import com.example.hotelapp.data.repository.HotelRepositoryImpl
import com.example.hotelapp.domain.repository.HotelRepository

class GetHotelUseCase(private val repository: HotelRepository) {
    fun getHotel(repository: HotelRepositoryImpl) = repository.getHotel()
}