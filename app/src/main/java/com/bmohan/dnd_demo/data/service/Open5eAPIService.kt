package com.bmohan.dnd_demo.data.service

import com.bmohan.dnd_demo.data.model.ItemResponse
import com.bmohan.dnd_demo.data.model.SpellResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Open5eAPIService {
    @GET("items")
    suspend fun getItems(@Query("limit") limit: Int = 20, @Query("page") page: Int): Response<ItemResponse>

    @GET("spells")
    suspend fun getSpells(@Query("limit") limit: Int = 20, @Query("page") page: Int): Response<SpellResponse>
}