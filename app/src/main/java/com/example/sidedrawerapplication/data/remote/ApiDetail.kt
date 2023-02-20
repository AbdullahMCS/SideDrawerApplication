package com.example.sidedrawerapplication.data.remote

import com.example.sidedrawerapplication.data.model.person.Person
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetail {

    @GET(ApiReference.USERS + ApiReference.RESPONSE_SIZE)
    suspend fun getPeople(): Response<Person>
}