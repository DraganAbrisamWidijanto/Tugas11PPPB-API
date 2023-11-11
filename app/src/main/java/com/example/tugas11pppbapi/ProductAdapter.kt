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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products = mList[position]

        holder.textview.setText(products.title)
        Picasso.get().load(products.thumbnail).into(holder.imageView)
        //Picasso.get().load(products.images[0]).into(holder.imageView)
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textview: TextView = itemView.findViewById(R.id.text_view)
    }
}