package com.example.listadorepositorios_recyclerview

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.listadorepositorios_recyclerview.model.Repositorio

class App:Application (){
    val ListaReposGeneral : MutableList<Repositorio> = mutableListOf()
}

val AppCompatActivity.app:App
    get() = this.application as App