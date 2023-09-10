package com.example.hotelapp.domain

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("hotels")
    var hotels:List<Hotels>
)