package com.futebolplacar.funCompose


import com.futebolplacar.R

fun verificLogoCampeonato(nameWindow: String): Int{

    val campeonatoIcon: Int = when(nameWindow){
        "Brasileirão Série A" -> R.drawable.logo_brasileirao_a
        "Brasileirão Série B" -> R.drawable.logo_brasileirao_b
        "La Liga" -> R.drawable.logo_la_liga
        "Premier League" -> R.drawable.logo_premier
        "Politica de Privacidade" -> R.drawable.icon_politica
        "Futebol Placar" -> R.drawable.icone_app_p
        else -> R.drawable.icon_error

    }
    return campeonatoIcon
}