package com.example.hotelapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hotelapp.data.HotelRepositoryImpl
import com.example.hotelapp.domain.GetHotelListUseCase
import com.example.hotelapp.domain.GetHotelResponce
import com.example.hotelapp.domain.GetHotelUseCase
import com.example.hotelapp.domain.HotelResponce
import com.example.hotelapp.domain.Hotels

class ViewModelHotel:ViewModel() {
    private val repository = HotelRepositoryImpl
    private val getHotelListUseCase = GetHotelListUseCase(repository)
    private val getHotelResponce = GetHotelResponce(repository)
     private val getHotelUseCase = GetHotelUseCase(repository)

    fun getHotelList(): LiveData<List<Hotels>> {
        return getHotelListUseCase.getHotelList(repository)
    }
    fun getResponce(): LiveData<HotelResponce> {
        return getHotelResponce.getHotelResponce(repository)
    }
    fun getHotel(): LiveData<HotelResponce>{
        return getHotelUseCase.getHotel(repository)
    }
}