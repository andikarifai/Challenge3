package com.example.abjad


import KataAdapter
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abjad.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var kamusAdapter: KataAdapter


    companion object {
        const val EXTRA_KATA_LIST = "extra_kata_list"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Ambil data list kata dari intent
        val kataList = intent.getSerializableExtra(EXTRA_KATA_LIST) as? List<Kamus>
        kataList?.let {
            // Inisialisasi RecyclerView dengan adapter untuk tombol kata
            kamusAdapter = KataAdapter(it) { kata ->
                onKataItemClick(kata)
            }
            // Set adapter kamus ke RecyclerView
            binding.rvKata.adapter = kamusAdapter
            binding.rvKata.layoutManager = LinearLayoutManager(this)


        }
    }
        // Deklarasikan fungsi onKataItemClick di luar blok let
        private fun onKataItemClick(kata: String) {
            val srcIntent = Intent(Intent.ACTION_VIEW)
            srcIntent.data = Uri.parse("https://www.google.com/search?q=$kata")
            startActivity(srcIntent)

            // Tampilkan RecyclerView untuk tombol kata
            binding.rvKata.visibility = View.VISIBLE
        }

}