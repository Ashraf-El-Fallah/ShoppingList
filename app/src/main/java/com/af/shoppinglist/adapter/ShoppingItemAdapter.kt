package com.af.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.af.shoppinglist.R
import com.af.shoppinglist.data.db.entites.ShoppingItem
import com.af.shoppinglist.databinding.ShoppingItemBinding
import com.af.shoppinglist.viewmodel.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShoppingItem) {
            binding.tvName.text = item.itemName
            binding.tvAmount.text = item.itemAmount.toString()

            binding.ivDelete.setOnClickListener {
                viewModel.delete(item)
            }

            //we can modify this as in the tutorial
            binding.ivPlus.setOnClickListener {
                item.itemAmount++
                viewModel.upsert(item)
            }

            binding.ivMinus.setOnClickListener {
                if (item.itemAmount > 0) {
                    item.itemAmount--
                    viewModel.upsert(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        holder.bind(currentShoppingItem)
    }
}