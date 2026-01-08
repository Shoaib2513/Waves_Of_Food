package com.example.wavesoffood.adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.databinding.PopularItemBinding

class PopularAdaptar (private val items: List<String>, private val price: List<String>, private val image : List<Int>,private val context: Context) : RecyclerView.Adapter<PopularAdaptar.popularViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): popularViewHolder {
        return popularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: popularViewHolder,
        position: Int
    ) {
        val item = items[position]
        val price = price[position]
        val images = image[position]
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", item)
                putExtra("MenuItemImage", images)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class popularViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView  = binding.imageView6
        fun bind(item: String, price: String, images: Int) {
            binding.foodNamePopular.text = item
            binding.PricePopular.text = price
            imagesView.setImageResource(images)
        }

    }
}