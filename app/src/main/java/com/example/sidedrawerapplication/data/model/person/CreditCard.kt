package com.example.sidedrawerapplication.data.model.person


import com.google.gson.annotations.SerializedName

data class CreditCard(
    @SerializedName("cc_number")
    val ccNumber: String?
)