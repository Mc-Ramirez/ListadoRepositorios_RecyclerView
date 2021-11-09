package com.example.listadorepositorios_recyclerview.model

data class Repositorio(
    val name:String,
    val avartarURL : String,
    val description : String,
    val license: String?,
    val topics: List<String>,
    val language: String?
){
    constructor(respuestaRepositorio: Respuesta_Repositorios) : this(
        respuestaRepositorio.name,
        respuestaRepositorio.owner.avatarURL,
        respuestaRepositorio.description,
        respuestaRepositorio.license?.name,
        respuestaRepositorio.topics,
        respuestaRepositorio.language
    )
}

fun Respuesta_Repositorios.aRepositorio():Repositorio{
    return Repositorio(
        this.name,
        this.owner.avatarURL,
        this.description,
        this.license?.name,
        this.topics,
        this.language
    )
}

fun Array<Respuesta_Repositorios>.aListaRepositorio():List<Repositorio>{
    return this.map { it.aRepositorio() }
}