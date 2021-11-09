package com.example.listadorepositorios_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorepositorios_recyclerview.model.Repositorio
import com.squareup.picasso.Picasso

class AdaptadorRepositorio (private val repositorios: MutableList<Repositorio>): RecyclerView.Adapter<AdaptadorRepositorio.ViewHolder>(){

    inner class ViewHolder(vista_item: View): RecyclerView.ViewHolder(vista_item){
        val tvNombreRepo:TextView = vista_item.findViewById(R.id.tv_nombre_repo)
        val tvDescripcionRepo:TextView = vista_item.findViewById(R.id.tv_descripcion)
        val ivAvatarRepo: ImageView = vista_item.findViewById(R.id.iv_avatar)
    }
    //que ocurre cuando se crea
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layaoutinflater = LayoutInflater.from(parent.context)
        val vista_item : View = layaoutinflater.inflate(R.layout.item_repositorio, parent, false)
        return ViewHolder(vista_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val repoActual : Repositorio = repositorios[position]
        holder.tvNombreRepo.text = repoActual.name
        holder.tvDescripcionRepo.text = repoActual.description
        Picasso.get().load(repoActual.avartarURL).placeholder(R.drawable.selection_band_overlay).into(holder.ivAvatarRepo)
    }

    //retornar cuantos repos hay a la funcion onBindViewHolder
    override fun getItemCount(): Int {
        return repositorios.size
    }
}