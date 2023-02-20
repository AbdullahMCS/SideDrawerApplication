package com.example.sidedrawerapplication.data.model.person


import com.google.gson.annotations.SerializedName

data class Employment(
    @SerializedName("key_skill")
    val keySkill: String?,
    @SerializedName("title")
    val title: String?
)