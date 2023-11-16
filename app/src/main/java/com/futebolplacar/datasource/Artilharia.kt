package com.futebolplacar.datasource

import kotlinx.serialization.Serializable
import java.util.stream.IntStream.range


data class Artilharia(
    var artilheiros: List<Posicao> = emptyList()

)
data class Posicao(
    val rank: String,
    val jogador: String,
    val time: String,
    val gols: String
)