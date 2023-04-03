package com.example.abjad


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abjad.databinding.FragmentAbjadBinding

class AbjadFragment : Fragment() {

    private lateinit var binding: FragmentAbjadBinding
    private lateinit var abjadAdapter: AbjadAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAbjadBinding.inflate(inflater, container, false)

        // Set up RecyclerView untuk tombol abjad
        abjadAdapter = AbjadAdapter(generateAbjad()) { abjad ->
            // Pass abjad ke listener di activity
            val listener = activity as OnAbjadItemClickListener
            listener.onAbjadItemClick(abjad)
        }

        binding.rvAbjad.adapter = abjadAdapter
        binding.rvAbjad.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

    // Generate daftar abjad dari A sampai Z
    private fun generateAbjad(): List<String> {
        return ('A'..'Z').map { it.toString() }
    }

    // Interface untuk listener saat tombol abjad diklik
    interface OnAbjadItemClickListener {
        fun onAbjadItemClick(abjad: String)
    }
}
