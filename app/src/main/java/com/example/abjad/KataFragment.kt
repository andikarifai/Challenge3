package com.example.abjad


import KataAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.abjad.databinding.FragmentKataBinding

class KataFragment : Fragment() {

    private lateinit var binding: FragmentKataBinding
    private lateinit var adapter: KataAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKataBinding.inflate(inflater, container, false)

        adapter = KataAdapter(emptyList()) { kata ->
            // Ketika salah satu item diklik, buka Google dengan kata sebagai keyword pencarian
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/search?q=$kata")
            startActivity(intent)
        }

        binding.rvKata.adapter = adapter
        binding.rvKata.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return binding.root
    }

}
