package com.example.hotelapp.data


import com.example.hotelapp.domain.HotelResponce
import com.example.hotelapp.domain.Hotels
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v2/lookup.json?query=moscow&lang=ru&lookFor=hotel")
    fun getHotelResponce():Single<HotelResponce>
    @GET("/api/v2/lookup.json?lang=ru&lookFor=hotel")
    fun getHotelitem( @Query("query") id:Int):Single<Hotels>


}