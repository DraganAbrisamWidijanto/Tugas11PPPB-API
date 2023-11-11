package com.example.tugas11pppbapi.network

import com.example.tugas11pppbapi.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Content-Type:application/json")
    @GET("/products")
    fun getAllProduct(): Call<ApiResponse>
}