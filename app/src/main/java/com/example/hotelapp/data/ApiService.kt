package com.example.hotelapp.data


import com.example.hotelapp.domain.HotelResponce
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v2/lookup.json?lang=ru&lookFor=hotel")
    fun getHotelResponce(@Query("query") id:Int):Single<HotelResponce>

    @GET("/api/v2/lookup.json?lang=ru&lookFor=hotel")
    fun getHotelResponce(@Query("query") id:String):Single<HotelResponce>

}