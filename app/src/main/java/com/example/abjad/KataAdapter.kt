package com.example.abjad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abjad.databinding.ItemKataBinding

class KataAdapter(
    private var data: List<Kamus>,
    private val onItemClickListener: (String) -> Unit
) : RecyclerView.Adapter<KataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemKataBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<Kamus>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemKataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(kamus: Kamus, onItemClickListener: (String) -> Unit) {
            binding.btnKata.text = kamus.kata
            binding.root.setOnClickListener {
                onItemClickListener(kamus.kata)
            }
        }
    }
}
