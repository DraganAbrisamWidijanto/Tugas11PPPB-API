package com.example.tugas11pppbapi.network

import com.example.tugas11pppbapi.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Interface [ApiService] mendefinisikan operasi-operasi API yang akan digunakan oleh Retrofit.
 */
interface ApiService {

    /**
     * Metode untuk mendapatkan daftar semua produk dari API.
     *
     * fun getAllProduct(): Call<ApiResponse>: Fungsi ini mendefinisikan
     operasi untuk mendapatkan semua produk. Ini mengembalikan objek
     Call<ApiResponse>, yang merupakan tipe yang digunakan oleh Retrofit
     untuk mengelola panggilan jaringan secara asynchronous.
     ApiResponse adalah tipe data respons yang diharapkan dari panggilan ini.
     */
    @Headers("Content-Type:application/json")
    @GET("/products")
    fun getAllProduct(): Call<ApiResponse>
}