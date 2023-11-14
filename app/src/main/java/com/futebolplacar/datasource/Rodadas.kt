package com.futebolplacar.datasource




data class Rodadas(
    val rodada1: List<Jogo> = emptyList(),
    val rodada2: List<Jogo> = emptyList(),
    val rodada3: List<Jogo> = emptyList(),
    val rodada4: List<Jogo> = emptyList(),
    val rodada5: List<Jogo> = emptyList(),
    val rodada6: List<Jogo> = emptyList(),
    val rodada7: List<Jogo> = emptyList(),
    val rodada8: List<Jogo> = emptyList(),
    val rodada9: List<Jogo> = emptyList(),
    val rodada10: List<Jogo> = emptyList(),
    val rodada11: List<Jogo> = emptyList(),
    val rodada12: List<Jogo> = emptyList(),
    val rodada13: List<Jogo> = emptyList(),
    val rodada14: List<Jogo> = emptyList(),
    val rodada15: List<Jogo> = emptyList(),
    val rodada16: List<Jogo> = emptyList(),
    val rodada17: List<Jogo> = emptyList(),
    val rodada18: List<Jogo> = emptyList(),
    val rodada19: List<Jogo> = emptyList(),
    val rodada20: List<Jogo> = emptyList(),
    val rodada21: List<Jogo> = emptyList(),
    val rodada22: List<Jogo> = emptyList(),
    val rodada23: List<Jogo> = emptyList(),
    val rodada24: List<Jogo> = emptyList(),
    val rodada25: List<Jogo> = emptyList(),
    val rodada26: List<Jogo> = emptyList(),
    val rodada27: List<Jogo> = emptyList(),
    val rodada28: List<Jogo> = emptyList(),
    val rodada29: List<Jogo> = emptyList(),
    val rodada30: List<Jogo> = emptyList(),
    val rodada31: List<Jogo> = emptyList(),
    val rodada32: List<Jogo> = emptyList(),
    val rodada33: List<Jogo> = emptyList(),
    val rodada34: List<Jogo> = emptyList(),
    val rodada35: List<Jogo> = emptyList(),
    val rodada36: List<Jogo> = emptyList(),
    val rodada37: List<Jogo> = emptyList(),
    val rodada38: List<Jogo> = emptyList(),


)


data class RodadasA(
    val n_rodada: String = "",
    val jogos: List<Jogo> = emptyList()
)

data class Jogo(
    val n_jogo: String,
    val data_local: String,
    val Time_A: String,
    val Gols_A: String,
    val Time_B: String,
    val Gols_B: String
)


