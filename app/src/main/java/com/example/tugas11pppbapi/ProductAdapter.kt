package com.example.tugas11pppbapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas11pppbapi.model.Products
import com.squareup.picasso.Picasso

class ProductAdapter(private val mList: List<Products>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    // Metode untuk membuat ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate layout dari item card
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    // Metode untuk mendapatkan jumlah item dalam RecyclerView
    override fun getItemCount(): Int {
        return mList.size
    }

    // Metode untuk menghubungkan data dengan ViewHolder di lokasi tertentu
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Dapatkan objek Products pada posisi tertentu
        val products = mList[position]

        // Atur teks judul TextView dengan judul produk
        holder.judultxt.text = products.title

        // Gunakan Picasso untuk memuat gambar thumbnail ke ImageView
        Picasso.get().load(products.thumbnail).into(holder.imageView)

        // Atur teks deskripsi TextView dengan deskripsi produk
        holder.deskripsi.text = products.description

        // Atur teks harga TextView dengan harga produk (konversi Int ke String)
        holder.harga.text = products.price.toString()
    }

    // ViewHolder untuk menyimpan referensi komponen tampilan dalam setiap item RecyclerView
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // Inisialisasi ImageView, TextView judul, TextView deskripsi, dan TextView harga
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val judultxt: TextView = itemView.findViewById(R.id.text_view)
        val deskripsi: TextView = itemView.findViewById(R.id.description)
        val harga: TextView = itemView.findViewById(R.id.hargatxt)
    }
}