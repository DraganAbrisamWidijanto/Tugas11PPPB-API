package com.example.tugas11pppbapi.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton class untuk mengelola koneksi Retrofit ke API.
 */
object ApiClient {
    // OkHttpClient untuk konfigurasi klien HTTP
    private val client = OkHttpClient.Builder().build()

    // Retrofit untuk mengonversi API interface menjadi implementasi yang dapat digunakan
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/") // Base URL API
        .addConverterFactory(GsonConverterFactory.create()) // Konverter JSON menggunakan Gson
        .client(client) // Menggunakan OkHttpClient yang telah dikonfigurasi
        .build()

    /**
     * Fungsi generik [buildService] bertanggung jawab untuk membuat layanan Retrofit dari suatu interface tertentu.
     */
    fun <T> buildService(service: Class<T>): T {
        // Memanggil metode create() pada objek retrofit dengan parameter interface service
        return retrofit.create(service)
    }
}