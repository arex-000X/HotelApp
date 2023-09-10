package com.example.hotelapp.domain

import com.google.gson.annotations.SerializedName

data class Hotels(
    @SerializedName("locationName")
    var locationName: String = "",
    @SerializedName("_score")
    var score: Long = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("label")
    var label:String = "",
    @SerializedName("location")
    var location: Location? = null,
    @SerializedName("locationId")
    var locationId: Int = 0,
    @SerializedName("fullName")
    var fullName:String = ""


) {
    override fun toString(): String {
        return "Hotels(locationName='$locationName', score=$score, id=$id, label='$label', location=$location, locationId=$locationId, fullName='$fullName')"
    }
}