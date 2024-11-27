package com.example.testcarelogikadata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testcarelogikadata.R

data class Product(
    val imageResId: Int,
    val name: String,
    val price: String,
    val location: String
)

class TabContentAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<TabContentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        val textViewProductName: TextView = view.findViewById(R.id.textViewProductName)
        val textViewPrice: TextView = view.findViewById(R.id.textViewPrice)
        val textViewLocation: TextView = view.findViewById(R.id.textViewLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tab_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.imageViewProduct.setImageResource(product.imageResId)
        holder.textViewProductName.text = product.name
        holder.textViewPrice.text = product.price
        holder.textViewLocation.text = product.location
    }

    override fun getItemCount(): Int = products.size
}