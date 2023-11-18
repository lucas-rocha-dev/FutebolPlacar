package com.futebolplacar.funCompose

import android.util.Log
import com.futebolplacar.R
import com.futebolplacar.viewModel.ViewModelFut

fun verificTime(name: String, viewModel: ViewModelFut): List<Any>{
    var image_time = 0
    var name_abrev = "A"
    val campeonato = viewModel.campeonato.value
    Log.d("campeonato", campeonato.toString())
    when(campeonato) {
        "Brasileiro A" -> {
                val infoTime = verificTimeSerieA(name)
                image_time = infoTime[0] as Int
                name_abrev = infoTime[1] as String
            }
        "Brasileiro B" -> {
            val infoTime = verificTimeSerieB(name)
            image_time = infoTime[0] as Int
            name_abrev = infoTime[1] as String
        }
        "La Liga" -> {
            val infoTime = verificTimeLaLiga(name)
            image_time = infoTime[0] as Int
            name_abrev = infoTime[1] as String
        }
        "Premier" -> {
            val infoTime = verificTimePremier(name)
            image_time = infoTime[0] as Int
            name_abrev = infoTime[1] as String
        }
        else -> {
            image_time = R.drawable.icon_error
            name_abrev = "Algo deu errado, desculpe!"
        }

    }

    return listOf(image_time, name_abrev)

}


fun verificTimeSerieA(name: String): List<Any>{
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
fun verificTimeSerieB(name: String): List<Any>{
    var image_time = 0
    var name_abrev = "A"

    when (name){
        "Vitória" -> {
            image_time = R.drawable.icon_vitoria
            name_abrev = "VIT"
        }
        "Criciúma" -> {
            image_time = R.drawable.icon_criciuma
            name_abrev = "CRI"
        }
        "Juventude" -> {
            image_time = R.drawable.icon_juventude
            name_abrev = "JUV"
        }
        "Atlético-GO" -> {
            image_time = R.drawable.icon_atleticogo
            name_abrev = "ACG"
        }
        "Sport" -> {
            image_time = R.drawable.icon_sport_recife
            name_abrev = "SPT"
        }
        "Vila Nova" -> {
            image_time = R.drawable.icon_vila_nova
            name_abrev = "VNO"
        }
        "Novorizontino" -> {
            image_time = R.drawable.icon_novorizontino
            name_abrev = "NOV"
        }
        "Mirassol" -> {
            image_time = R.drawable.icon_mirassol
            name_abrev = "MIR"
        }
        "Guarani" -> {
            image_time = R.drawable.icon_guarani
            name_abrev = "GUA"
        }
        "CRB" -> {
            image_time = R.drawable.icon_crb
            name_abrev = "CRB"
        }
        "Ceará" -> {
            image_time = R.drawable.icon_ceara
            name_abrev = "CEA"
        }
        "Botafogo-SP" -> {
            image_time = R.drawable.icon_botafogo_sp
            name_abrev = "BSP"
        }
        "Avaí" -> {
            image_time = R.drawable.icon_avai
            name_abrev = "AVA"
        }
        "Ituano" -> {
            image_time = R.drawable.icon_ituano
            name_abrev = "ITU"
        }
        "Ponte Preta" -> {
            image_time = R.drawable.icon_ponte_preta
            name_abrev = "PON"
        }
        "Tombense" -> {
            image_time = R.drawable.icon_tombense
            name_abrev = "TOM"
        }
        "Chapecoense" -> {
            image_time = R.drawable.icon_chapecoense
            name_abrev = "CHA"
        }
        "Sampaio Corrêa" -> {
            image_time = R.drawable.icon_sampaio_correa
            name_abrev = "SCO"
        }
        "Londrina" -> {
            image_time = R.drawable.icon_londrina
            name_abrev = "LEC"
        }
        "ABC" -> {
            image_time = R.drawable.icon_abc
            name_abrev = "ABC"
        }

        else -> {
            image_time = R.drawable.icon_error
            name_abrev = "ERR"
        }
    }

    return listOf(image_time, name_abrev)
}

fun verificTimeLaLiga(name: String): List<Any>{
    var image_time = 0
    var name_abrev = "A"

    when (name){
        "Girona" -> {
            image_time = R.drawable.icon_girona
            name_abrev = "GIR"
        }
        "Real Madrid" -> {
            image_time = R.drawable.icon_real_madrid
            name_abrev = "MAD"
        }
        "Barcelona" -> {
            image_time = R.drawable.icon_barcelona
            name_abrev = "BAR"
        }
        "Atlético de Madrid", "Atlético"  -> {
            image_time = R.drawable.icon_atletico_madrid
            name_abrev = "ATL"
        }
        "Athletic Bilbao", "Athletic"-> {
            image_time = R.drawable.icon_athletic_bilbao
            name_abrev = "ATH"
        }
        "Real Sociedad" -> {
            image_time = R.drawable.icon_real_sociedad
            name_abrev = "RSO"
        }
        "Betis", "Real Betis" -> {
            image_time = R.drawable.icon_betis
            name_abrev = "BET"
        }
        "Las Palmas" -> {
            image_time = R.drawable.icon_la_palmas
            name_abrev = "LPA"
        }
        "Valencia" -> {
            image_time = R.drawable.icon_valencia
            name_abrev = "VAL"
        }
        "Rayo Vallecano" -> {
            image_time = R.drawable.icon_rayo_vallecano
            name_abrev = "RVL"
        }
        "Getafe" -> {
            image_time = R.drawable.icon_getafe
            name_abrev = "GET"
        }
        "Osasuna" -> {
            image_time = R.drawable.icon_osasuna
            name_abrev = "OSA"
        }
        "Sevilla" -> {
            image_time = R.drawable.icon_sevilla
            name_abrev = "SEV"
        }
        "Villarreal" -> {
            image_time = R.drawable.icon_villar_real
            name_abrev = "VIL"
        }
        "Alavés" -> {
            image_time = R.drawable.icon_alaves
            name_abrev = "ALV"
        }
        "Cádiz" -> {
            image_time = R.drawable.icon_cadiz
            name_abrev = "CAD"
        }
        "Mallorca" -> {
            image_time = R.drawable.icon_mallorca
            name_abrev = "MLC"
        }
        "Celta" -> {
            image_time = R.drawable.icon_celta
            name_abrev = "CVI"
        }
        "Granada" -> {
            image_time = R.drawable.icon_granada
            name_abrev = "GRA"
        }
        "Almería" -> {
            image_time = R.drawable.icon_almeria
            name_abrev = "ALM"
        }

        else -> {
            image_time = R.drawable.icon_error
            name_abrev = "ERR"
        }
    }

    return listOf(image_time, name_abrev)
}

fun verificTimePremier(name: String): List<Any>{
    var image_time = 0
    var name_abrev = "A"

    when (name){
        "Manchester City" -> {
            image_time = R.drawable.icon_manchester_city
            name_abrev = "MAC"
        }
        "Liverpool" -> {
            image_time = R.drawable.icon_liverpool
            name_abrev = "LIV"
        }
        "Arsenal" -> {
            image_time = R.drawable.icon_arsenal
            name_abrev = "ARS"
        }
        "Tottenham" -> {
            image_time = R.drawable.icon_tottenham
            name_abrev = "TOT"
        }
        "Aston Villa" -> {
            image_time = R.drawable.icon_aston_villa
            name_abrev = "ASV"
        }
        "Manchester United" -> {
            image_time = R.drawable.icon_manchester_united
            name_abrev = "MAN"
        }
        "Newcastle" -> {
            image_time = R.drawable.icon_newcastle
            name_abrev = "NEW"
        }
        "Brighton" -> {
            image_time = R.drawable.icon_brighton
            name_abrev = "BFC"
        }
        "West Ham" -> {
            image_time = R.drawable.icon_west_ham
            name_abrev = "WTH"
        }
        "Chelsea" -> {
            image_time = R.drawable.icon_chelsea
            name_abrev = "CHE"
        }
        "Brentford" -> {
            image_time = R.drawable.icon_brentford
            name_abrev = "BRE"
        }
        "Wolverhampton" -> {
            image_time = R.drawable.icon_wolverhampton
            name_abrev = "WOL"
        }
        "Crystal Palace" -> {
            image_time = R.drawable.icon_crystal_palace
            name_abrev = "CPA"
        }
        "Nottingham Forest" -> {
            image_time = R.drawable.icon_nottingham_forest
            name_abrev = "NOT"
        }
        "Fulham" -> {
            image_time = R.drawable.icon_fulham
            name_abrev = "FUL"
        }
        "Bournemouth" -> {
            image_time = R.drawable.icon_bournemouth
            name_abrev = "BOU"
        }
        "Luton Town" -> {
            image_time = R.drawable.icon_luton_town
            name_abrev = "LUT"
        }
        "Sheffield United" -> {
            image_time = R.drawable.icon_sheffield_united
            name_abrev = "SHU"
        }
        "Everton" -> {
            image_time = R.drawable.icon_everton
            name_abrev = "EVE"
        }
        "Burnley" -> {
            image_time = R.drawable.icon_burnley
            name_abrev = "BUR"
        }

        else -> {
            image_time = R.drawable.icon_error
            name_abrev = "ERR"
        }
    }

    return listOf(image_time, name_abrev)
}
