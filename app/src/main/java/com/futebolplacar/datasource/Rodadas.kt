package com.futebolplacar.datasource



data class RodadasA(
    val nRodada: String = "",
    val jogos: List<Jogo> = emptyList()
)

data class Jogo(
    val nJogo: String,
    val dataLocal: String,
    val timeA: String,
    val golsA: String,
    val timeB: String,
    val golsB: String
)


