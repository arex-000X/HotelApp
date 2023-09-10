package com.example.hotelapp.domain

import androidx.lifecycle.LiveData
import com.example.hotelapp.data.HotelRepositoryImpl

class GetHotelListUseCase(private val repository: HotelRepository) {

    fun getHotelList(repository: HotelRepositoryImpl): LiveData<List<Hotels>> = repository.getHotelList()
}