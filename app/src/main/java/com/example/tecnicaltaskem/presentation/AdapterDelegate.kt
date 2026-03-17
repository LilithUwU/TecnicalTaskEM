package com.example.tecnicaltaskem.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate {
    fun isForViewType(item: Any): Boolean
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Any)
}

class DelegateAdapter(private val delegates: List<AdapterDelegate>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Any> = emptyList()

    fun setItems(newItems: List<Any>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        delegates.forEachIndexed { index, delegate ->
            if (delegate.isForViewType(item)) {
                return index
            }
        }
        throw IllegalArgumentException("No delegate found for $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        delegates[getItemViewType(position)].onBindViewHolder(holder, item)
    }

    override fun getItemCount(): Int = items.size
}
