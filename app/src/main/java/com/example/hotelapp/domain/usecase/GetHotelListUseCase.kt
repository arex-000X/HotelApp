package com.example.hotelapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.hotelapp.data.repository.HotelRepositoryImpl
import com.example.hotelapp.domain.repository.HotelRepository
import com.example.hotelapp.domain.model.Hotels
import com.example.hotelapp.domain.model.Results

class GetHotelListUseCase(private val repository: HotelRepository) {

    fun getHotelList(repository: HotelRepositoryImpl): LiveData<List<Hotels>> = repository.getHotelList()
}