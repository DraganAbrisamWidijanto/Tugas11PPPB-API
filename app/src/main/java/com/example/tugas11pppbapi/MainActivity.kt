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

    var data = ArrayList<Products>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager= LinearLayoutManager(this)

        getAllProducts()
    }

    private fun getAllProducts() {
        val retrofit= ApiClient.buildService(ApiService::class.java)
        retrofit.getAllProduct().enqueue(object : retrofit2.Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                //mengantisipasi NullPointerException
                try{
                    val responseBody= response.body()!!
                    data=responseBody.products

                    var adapter= ProductAdapter(data)
                    binding.rv.adapter=adapter
                }
                catch (ex: java.lang.Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed", "onFailure: ${t.message}")
            }
        })
    }
}