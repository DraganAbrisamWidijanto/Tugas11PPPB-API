package com.example.tugas11pppbapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas11pppbapi.databinding.ActivityMainBinding
import com.example.tugas11pppbapi.model.ApiResponse
import com.example.tugas11pppbapi.model.Products
import com.example.tugas11pppbapi.network.ApiClient
import com.example.tugas11pppbapi.network.ApiService
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Inisialisasi ArrayList untuk menyimpan data produk
    var data = ArrayList<Products>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan ViewBinding untuk mengatur tata letak aktivitas
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur LinearLayoutManager untuk RecyclerView
        binding.rv.layoutManager = LinearLayoutManager(this)

        // Panggil metode untuk mendapatkan semua produk
        getAllProducts()
    }


    private fun getAllProducts() {
        // Bangun layanan Retrofit
        val retrofit = ApiClient.buildService(ApiService::class.java)

        // Enqueue asynchronous request
        retrofit.getAllProduct().enqueue(object : retrofit2.Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                // Mengantisipasi NullPointerException
                try {
                    // Dapatkan data produk dari respons
                    val responseBody = response.body()

                    // Periksa apakah respons tidak null dan daftar produk tidak null
                    if (responseBody != null && responseBody.products.isNotEmpty()) {
                        // Isi data dengan daftar produk dari respons
                        data = responseBody.products

                        // Buat adapter dan atur ke RecyclerView
                        val adapter = ProductAdapter(data)
                        binding.rv.adapter = adapter
                    } else {
                        // Respons kosong atau daftar produk kosong
                        Log.e("Response Error", "Empty response or no products in the list.")
                    }
                } catch (ex: Exception) {
                    // Tangkap exception jika terjadi kesalahan
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Tangkap kegagalan request
                Log.e("Failed", "onFailure: ${t.message}")
            }
        })
    }
}