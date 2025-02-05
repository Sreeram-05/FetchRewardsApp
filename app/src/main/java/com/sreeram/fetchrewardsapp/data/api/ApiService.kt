package com.sreeram.fetchrewardsapp.data.api

import com.sreeram.fetchrewardsapp.data.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}