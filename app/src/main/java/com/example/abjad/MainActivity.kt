package com.example.abjad

import KataAdapter
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abjad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var abjadAdapter: AbjadAdapter
    private lateinit var kataAdapter: KataAdapter
    private lateinit var kamusList: List<Kamus>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        kamusList = generateKamus()

        // Inisialisasi RecyclerView dengan adapter untuk tombol abjad
        abjadAdapter = AbjadAdapter(generateAbjad()) { abjad ->
            // Ketika tombol abjad diklik, tampilkan tombol kata yang sesuai dengan abjad tersebut
            val filteredList = kamusList.filter { it.abjad == abjad }
            kataAdapter.setData(filteredList)
            binding.rvKata.visibility = View.VISIBLE
        }

        // Inisialisasi RecyclerView dengan adapter untuk tombol kata
        kataAdapter = KataAdapter(kamusList) { kata ->
            onKataItemClick(kata)
        }
        binding.rvKata.adapter = kataAdapter
        binding.rvKata.layoutManager = LinearLayoutManager(this)

        // Sembunyikan RecyclerView untuk tombol kata sampai ada yang dipilih
        binding.rvKata.visibility = View.GONE

        // Set adapter tombol abjad ke RecyclerView
        binding.rvAbjad.adapter = abjadAdapter
        binding.rvAbjad.layoutManager = GridLayoutManager(this, 4)
    }

    private fun onKataItemClick(kata: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/search?q=$kata")
        startActivity(intent)
    }

    private fun generateAbjad(): List<String> {
        return ('A'..'Z').map { it.toString() }
    }

    private fun generateKamus(): List<Kamus> {
        return listOf(
            Kamus("A", "Apple"),
            Kamus("A", "Aeroplane"),
            Kamus("A", "Ant"),
            Kamus("B", "Ball"),
            Kamus("B", "Banana"),
            Kamus("B", "Butterfly"),
            Kamus("C", "Cat"),
            Kamus("C", "Car"),
            Kamus("C", "Cake"),
            Kamus("D", "Dog"),
            Kamus("D", "Dolphin"),
            Kamus("D", "Dragonfly"),
            Kamus("E", "Elephant"),
            Kamus("E", "Eagle"),
            Kamus("E", "Egg"),
            Kamus("F", "Fish"),
            Kamus("F", "Frog"),
            Kamus("F", "Flower"),
            Kamus("G", "Giraffe"),
            Kamus("G", "Grapes"),
            Kamus("G", "Goat"),
            Kamus("H", "Horse"),
            Kamus("H", "Hamburger"),
            Kamus("H", "Honey"),
            Kamus("I", "Iguana"),
            Kamus("I", "Ice Cream"),
            Kamus("I", "Insect"),
            Kamus("J", "Jellyfish"),
            Kamus("J", "Juice"),
            Kamus("J", "Jacket"),
            Kamus("K", "Kangaroo"),
            Kamus("K", "Kiwi"),
            Kamus("K", "Kite"),
            Kamus("L", "Lion"),
            Kamus("L", "Lemon"),
            Kamus("L", "Lollipop"),
            Kamus("M", "Monkey"),
            Kamus("M", "Mango"),
            Kamus("M", "Moon"),
            Kamus("N", "Nest"),
            Kamus("N", "Noodle"),
            Kamus("N", "Nose"),
            Kamus("O", "Octopus"),
            Kamus("O", "Orange"),
            Kamus("O", "Owl"),
            Kamus("P", "Panda"),
            Kamus("P", "Pizza"),
            Kamus("P", "Pencil"),
            Kamus("Q", "Queen"),
            Kamus("Q", "Quilt"),
            Kamus("Q", "Question"),
            Kamus("R", "Rabbit"),
            Kamus("R", "Rainbow"),
            Kamus("R", "Rose"),
            Kamus("S", "Snake"),
            Kamus("S", "Strawberry"),
            Kamus("S", "Sun"),
            Kamus("T", "Tiger"),
            Kamus("T", "Tomato"),
            Kamus("T", "Truck"),
            Kamus("U", "Umbrella"),
            Kamus("U", "Unicorn"),
            Kamus("U", "Udon"),
            Kamus("V", "Vase"),
            Kamus("V", "Vanilla"),
            Kamus("V", "Violin"),
            Kamus("W", "Wolf"),
            Kamus("W", "Watermelon"),
            Kamus("W", "Watch"),
            Kamus("X", "X-ray"),
            Kamus("X", "Xylophone"),
            Kamus("X", "Xerus"),
            Kamus("Y", "Yak"),
            Kamus("Y", "Yacht"),
            Kamus("Y", "Yawn"),
            Kamus("Z", "Zebra"),
            Kamus("Z", "Zoo"),
            Kamus("Z", "Zucchini")
        )
    }

}
