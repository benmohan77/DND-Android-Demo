package com.bmohan.dnd_demo.data.service

import com.bmohan.dnd_demo.data.model.SRDApiDirectories
import retrofit2.Response
import retrofit2.http.GET

interface SrdAPIService {
    @GET("2014")
    suspend fun get2014Directories(): Response<SRDApiDirectories>
}