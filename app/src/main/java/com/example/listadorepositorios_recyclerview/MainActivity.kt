package com.example.listadorepositorios_recyclerview

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorepositorios_recyclerview.model.RecyclerFakeData
import com.example.listadorepositorios_recyclerview.model.Respuesta_Repositorios
import com.example.listadorepositorios_recyclerview.model.aListaRepositorio
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var adapRepo : AdaptadorRepositorio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = application as App
        val recLista = app.ListaReposGeneral
        val arrayRepos = Gson().fromJson(RecyclerFakeData.repositoriesJson, Array<Respuesta_Repositorios>::class.java)

        recLista.addAll(arrayRepos.aListaRepositorio())
        adapRepo = AdaptadorRepositorio(recLista)
        val recycler:RecyclerView = findViewById(R.id.rv)
        val layaoutRv = LinearLayoutManager(this)
        recycler.layoutManager = layaoutRv
        recycler.adapter = adapRepo
    }
}