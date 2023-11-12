package com.example.tugas11pppbapi.model

import com.google.gson.annotations.SerializedName

/**
 * ApiResponse adalah data class yang mewakili respons dari API
 */
final data class ApiResponse(
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("skip") var skip: Int? = null,
    @SerializedName("limit") var limit: Int? = null
)

/**
 * Products adalah data class yang mewakili informasi tentang suatu produk
 */
data class Products(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("discountPercentage") var discountPercentage: Double? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("stock") var stock: Int? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("images") var images: ArrayList<String> = arrayListOf()
)

/**
 * Data class ini digunakan untuk mengelola dan menyimpan informasi produk yang diterima
 * dari API dalam format yang mudah diakses dan dikelola di dalam kode Kotlin.
 * Annotation @SerializedName digunakan untuk menentukan nama yang diharapkan dari properti
 * saat melakukan serialisasi/deserialisasi JSON menggunakan library seperti Gson.
 */
