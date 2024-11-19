package glima02.com.github.globalsolution2sem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import glima02.com.github.globalsolution2sem.model.Dica

class DicaAdapter(private val dicas: List<Dica>) : RecyclerView.Adapter<DicaAdapter.DicaViewHolder>() {

    class DicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloDica: TextView = itemView.findViewById(R.id.tituloDica)
        val descricaoDica: TextView = itemView.findViewById(R.id.descricaoDica)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.tituloDica.text = dica.titulo
        holder.descricaoDica.text = dica.descricao
    }

    override fun getItemCount(): Int {
        return dicas.size
    }
}
