package com.example.hotelapp.domain

import com.google.gson.annotations.SerializedName


data class HotelResponce(
    @SerializedName("results")
    var results: Results,
    @SerializedName("status")
    val status:String = ""
)