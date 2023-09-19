package com.example.hotelapp.presentation.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hotelapp.data.repository.HotelRepositoryImpl
import com.example.hotelapp.domain.usecase.GetHotelListUseCase
import com.example.hotelapp.domain.usecase.GetHotelUseCase
import com.example.hotelapp.domain.model.HotelResponce
import com.example.hotelapp.domain.model.Hotels
import com.example.hotelapp.domain.model.Results

class ViewModelHotel:ViewModel() {
    private val repository = HotelRepositoryImpl
    private val getHotelListUseCase = GetHotelListUseCase(repository)
     private val getHotelUseCase = GetHotelUseCase(repository)

    fun getHotelList(): LiveData<List<Hotels>> {
        return getHotelListUseCase.getHotelList(repository)
    }

    fun getHotel(id:Int): LiveData<HotelResponce> {
        return getHotelUseCase.getHotel(repository,id)
    }
}