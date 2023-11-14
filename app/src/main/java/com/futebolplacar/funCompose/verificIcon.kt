package com.futebolplacar.funCompose

import com.futebolplacar.Armazem
import com.futebolplacar.R

fun verificIcon(name: String): Int{
    val imageTime: Int


    when (name){
        "BOT", "Botafogo" -> {
            imageTime = R.drawable.icon_botafogo

        }
        "PAL", "Palmeiras" -> {
            imageTime = R.drawable.icon_palmeiras
        }
        "GRE", "Grêmio" -> {
            imageTime = R.drawable.icon_gremio
        }
        "RBB", "Bragantino" -> {
            imageTime = R.drawable.icon_bragantino
        }
        "FLU", "Fluminense" -> {
            imageTime = R.drawable.icon_fluminense
        }
        "CAP", "Athletico-PR" -> {
            imageTime = R.drawable.icon_athletico_pr

        }
        "FLA", "Flamengo" -> {
            imageTime = R.drawable.icon_flamengo
        }
        "FOR", "Fortaleza" -> {
            imageTime = R.drawable.icon_fortaleza
        }
        "CAM", "Atlético-MG" -> {
            imageTime = R.drawable.icon_atletico_mg

        }
        "SAO", "São Paulo" -> {
            imageTime = R.drawable.icon_sao_paulo

        }
        "COR", "Corinthians" -> {
            imageTime = R.drawable.icon_corinthians
        }
        "CUI", "Cuiabá" -> {
            imageTime = R.drawable.icon_cuiaba
        }
        "CRU", "Cruzeiro" -> {
            imageTime = R.drawable.icon_cruzeiro
        }
        "INT", "Internacional" -> {
            imageTime = R.drawable.icon_internacional
        }
        "VAS", "Vasco" -> {
            imageTime = R.drawable.icon_vasco_da_gama
        }
        "GOI", "Goiás" -> {
            imageTime = R.drawable.icon_goias
        }
        "BAH", "Bahia" -> {
            imageTime = R.drawable.icon_bahia
        }
        "SAN", "Santos" -> {
            imageTime = R.drawable.icon_santos
        }
        "AME", "América-MG" -> {
            imageTime = R.drawable.icon_america_mg
        }
        "CFC", "Coritiba" -> {
            imageTime = R.drawable.icon_coritiba

        }

        else ->  {
            imageTime = R.drawable.icon_error

        }
    }

    return imageTime


}