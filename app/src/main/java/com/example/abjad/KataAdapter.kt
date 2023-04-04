import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abjad.Kamus
import com.example.abjad.databinding.ItemKataBinding


class KataAdapter(private var data: List<Kamus>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<KataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemKataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(private val binding: ItemKataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Kamus) {
            binding.btnKata.text = item.kata
            binding.root.setOnClickListener {
                onItemClick(item.kata)
            }
        }
    }
}

