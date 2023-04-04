package com.example.abjad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abjad.databinding.ItemAbjadBinding


class AbjadAdapter(
    private val data: List<String>,
    private val onItemClick: (abjad: String) -> Unit
) : RecyclerView.Adapter<AbjadAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemAbjadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(abjad: String) {
            binding.btnAbjad.text = abjad

            // Saat tombol abjad diklik, panggil onItemClick dengan abjad yang ditekan
            binding.btnAbjad.setOnClickListener {
                onItemClick(abjad)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAbjadBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
