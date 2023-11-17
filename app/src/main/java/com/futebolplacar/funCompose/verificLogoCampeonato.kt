package com.futebolplacar.funCompose


import com.futebolplacar.R
import com.futebolplacar.viewModel.ViewModelFut

fun verificLogoCampeonato(viewModel: ViewModelFut, nameWindow: String): Int{
    var campeonatoIcon: Int

    when(nameWindow){
        "Brasileirão Série A" -> campeonatoIcon = R.drawable.logo_brasileirao_a
        "Brasileirão Série B" -> campeonatoIcon = R.drawable.logo_brasileirao_b
        "La Liga" -> campeonatoIcon = R.drawable.logo_la_liga
        "Premier League" -> campeonatoIcon = R.drawable.logo_premier
        "Politica de Privacidade" -> campeonatoIcon = R.drawable.icon_politica
        "Futebol Placar" -> campeonatoIcon = R.drawable.icone_app_p
        else -> campeonatoIcon = R.drawable.icon_error

    }
    return campeonatoIcon
}