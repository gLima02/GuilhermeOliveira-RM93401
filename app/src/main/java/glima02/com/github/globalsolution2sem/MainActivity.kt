package glima02.com.github.globalsolution2sem

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import glima02.com.github.globalsolution2sem.model.Dica
import glima02.com.github.globalsolution2sem.viewmodel.ItemsAdapter
import glima02.com.github.globalsolution2sem.viewmodel.ItemsViewModel
import glima02.com.github.globalsolution2sem.viewmodel.ItemsViewModelFactory
/**/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dicas = listOf(
            Dica("Use lâmpadas LED", "Elas consomem menos energia e duram mais."),
            Dica("Desligue aparelhos que não estão em uso", "Aparelhos consomem energia mesmo em standby."),
            Dica("Reutilize água da chuva", "Economize água potável usando água da chuva para tarefas.")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = DicaAdapter(dicas) { dica ->
            // Exibe um Toast com mais detalhes da dica
            Toast.makeText(
                this,
                "Detalhes: ${dica.titulo}\n${dica.descricao}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
