package com.futebolplacar.datasource




data class Artilharia(
    var artilheiros: List<Posicao> = emptyList()

)
data class Posicao(
    val rank: String,
    val jogador: String,
    val time: String,
    val gols: String
)