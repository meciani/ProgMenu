package it.cni.progmen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ListaSpesa : AppCompatActivity() {

    private lateinit var listaSpesaRecyclerView : RecyclerView
    //private lateinit var listAdapter : ListAdapter
    private lateinit var spesaList : ArrayList<Menu>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_spesa)


    }
}