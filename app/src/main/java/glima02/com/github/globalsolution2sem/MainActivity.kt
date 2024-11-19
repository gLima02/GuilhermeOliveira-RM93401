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

        // Dados de exemplo
        val dicas = listOf(
            Dica("Use lâmpadas LED", "Elas consomem menos energia e duram mais."),
            Dica("Desligue aparelhos que não estão em uso", "Aparelhos consomem energia mesmo em standby."),
            Dica("Reutilize água da chuva", "Economize água potável usando água da chuva para tarefas.")
        )

        // Configuração da RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configura o adapter com o callback de clique
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










    /*
    private lateinit var viewModel: ItemsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Ecodicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter { item ->
            viewModel.removeItem(item)
        }
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Adicione uma dica sustentável"
                return@setOnClickListener
            }

            viewModel.addItem(editText.text.toString())
            editText.text.clear()
        }

        val viewModelFactory = ItemsViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemsViewModel::class.java)

        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
    */
