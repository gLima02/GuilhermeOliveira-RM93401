package glima02.com.github.globalsolution2sem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import glima02.com.github.globalsolution2sem.model.Dica

class DicaAdapter(
    private val dicas: List<Dica>,
    private val onItemClick: (Dica) -> Unit // Callback para cliques no item
) : RecyclerView.Adapter<DicaAdapter.DicaViewHolder>() {

    class DicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titulo: TextView = itemView.findViewById(R.id.tituloDica)
        private val descricao: TextView = itemView.findViewById(R.id.descricaoDica)

        fun bind(dica: Dica, onItemClick: (Dica) -> Unit) {
            titulo.text = dica.titulo
            descricao.text = dica.descricao

            // Configura o listener de clique no item
            itemView.setOnClickListener {
                onItemClick(dica)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        holder.bind(dicas[position], onItemClick)
    }

    override fun getItemCount() = dicas.size
}

