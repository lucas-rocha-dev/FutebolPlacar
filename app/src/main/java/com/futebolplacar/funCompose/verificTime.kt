package com.futebolplacar.funCompose

import com.futebolplacar.R

fun verificTime(name: String): List<Any>{
    var image_time = 0
    var name_abrev = "A"

    when (name){
        "Botafogo" -> {
            image_time = R.drawable.icon_botafogo
            name_abrev = "BOT"
        }
        "Palmeiras" -> {
            image_time = R.drawable.icon_palmeiras
            name_abrev = "PAL"
        }
        "Grêmio" -> {
            image_time = R.drawable.icon_gremio
            name_abrev = "GRE"
        }
        "Bragantino" -> {
            image_time = R.drawable.icon_bragantino
            name_abrev = "RBB"
        }
        "Fluminense" -> {
            image_time = R.drawable.icon_fluminense
            name_abrev ="FLU"
        }
        "Athletico-PR" -> {
            image_time = R.drawable.icon_athletico_pr
            name_abrev = "CAP"
        }
        "Flamengo" -> {
            image_time = R.drawable.icon_flamengo
            name_abrev = "FLA"
        }
        "Fortaleza" -> {
            image_time = R.drawable.icon_fortaleza
            name_abrev = "FOR"
        }
        "Atlético-MG" -> {
            image_time = R.drawable.icon_atletico_mg
            name_abrev = "CAM"

        }
        "São Paulo" -> {
            image_time = R.drawable.icon_sao_paulo
            name_abrev = "SAO"

        }
        "Corinthians" -> {
            image_time = R.drawable.icon_corinthians
            name_abrev = "COR"
        }
        "Cuiabá" -> {
            image_time = R.drawable.icon_cuiaba
            name_abrev = "CUI"
        }
        "Cruzeiro" -> {
            image_time = R.drawable.icon_cruzeiro
            name_abrev = "CRU"
        }
        "Internacional" -> {
            image_time = R.drawable.icon_internacional
            name_abrev = "INT"
        }
        "Vasco" -> {
            image_time = R.drawable.icon_vasco_da_gama
            name_abrev = "VAS"
        }
        "Goiás" -> {
            image_time = R.drawable.icon_goias
            name_abrev = "GOI"
        }
        "Bahia" -> {
            image_time = R.drawable.icon_bahia
            name_abrev = "BAH"
        }
        "Santos" -> {
            image_time = R.drawable.icon_santos
            name_abrev = "SAN"
        }
        "América-MG" -> {
            image_time = R.drawable.icon_america_mg
            name_abrev = "AME"
        }
        "Coritiba" -> {
            image_time = R.drawable.icon_coritiba
            name_abrev = "CFC"
        }

        else -> image_time = R.drawable.icon_error
    }

    return listOf(image_time, name_abrev)

}