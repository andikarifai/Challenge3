    package com.example.abjad


    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle

    import androidx.recyclerview.widget.LinearLayoutManager
    import com.example.abjad.DetailActivity.Companion.EXTRA_KATA_LIST
    import com.example.abjad.databinding.ActivityMainBinding
    import java.io.Serializable


    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding
        private lateinit var abjadAdapter: AbjadAdapter
        private lateinit var kamusList: List<Kamus>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            kamusList = generateKamus()

            // Inisialisasi RecyclerView dengan adapter untuk tombol abjad
            abjadAdapter = AbjadAdapter(generateAbjad()) { abjad ->
                // Mendapatkan daftar kata-kata yang hanya memuat huruf abjad yang diklik
                val filteredKamusList = kamusList.filter { it.abjad == abjad }


                // Ketika tombol abjad diklik, tampilkan DetailActivity yang sesuai dengan abjad tersebut
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(EXTRA_KATA_LIST, filteredKamusList as Serializable)
                startActivity(intent)

            }

            // Set adapter tombol abjad ke RecyclerView
            binding.rvAbjad.adapter = abjadAdapter
            binding.rvAbjad.layoutManager = LinearLayoutManager(this)
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
