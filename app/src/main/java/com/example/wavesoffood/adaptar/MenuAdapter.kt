package com.example.wavesoffood.adaptar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private val menuImages: MutableList<Int>,
    private val context: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var itemClickListener: OnClickListener? = null   // ✅ Correct type

    fun setOnClickListener(listener: OnClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition   // ✅ safer than adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Notify custom listener
                    itemClickListener?.onItemClick(position)

                    // Open details activity
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra("MenuItemName", menuItemsName[position])
                        putExtra("MenuItemImage", menuImages[position])
                    }
                    context.startActivity(intent)
                }
            }
        }

        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemsName[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(menuImages[position])
            }
        }
    }

    interface OnClickListener {
        fun onItemClick(position: Int)
    }
}
