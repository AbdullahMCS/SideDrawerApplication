package com.example.sidedrawerapplication.data.model.person


import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lng")
    val lng: Double?
)