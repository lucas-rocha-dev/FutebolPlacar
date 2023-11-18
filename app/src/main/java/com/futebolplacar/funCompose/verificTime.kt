package com.futebolplacar.funCompose

import com.futebolplacar.R
import com.futebolplacar.viewModel.ViewModelFut

fun verificTime(name: String, viewModel: ViewModelFut): List<Any>{
    val imageTime: Int
    val nameAbrev: String
    val campeonato = viewModel.campeonato.value
    when(campeonato) {
        "Brasileiro A" -> {
                val infoTime = verificTimeSerieA(name)
                imageTime = infoTime[0] as Int
                nameAbrev = infoTime[1] as String
            }
        "Brasileiro B" -> {
            val infoTime = verificTimeSerieB(name)
            imageTime = infoTime[0] as Int
            nameAbrev = infoTime[1] as String
        }
        "La Liga" -> {
            val infoTime = verificTimeLaLiga(name)
            imageTime = infoTime[0] as Int
            nameAbrev = infoTime[1] as String
        }
        "Premier" -> {
            val infoTime = verificTimePremier(name)
            imageTime = infoTime[0] as Int
            nameAbrev = infoTime[1] as String
        }
        else -> {
            imageTime = R.drawable.icon_error
            nameAbrev = "Algo deu errado, desculpe!"
        }

    }

    return listOf(imageTime, nameAbrev)

}


fun verificTimeSerieA(name: String): List<Any>{
    val imageTime: Int
    val nameAbrev: String

    when (name){
        "Botafogo" -> {
            imageTime = R.drawable.icon_botafogo
            nameAbrev = "BOT"
        }
        "Palmeiras" -> {
            imageTime = R.drawable.icon_palmeiras
            nameAbrev = "PAL"
        }
        "Grêmio" -> {
            imageTime = R.drawable.icon_gremio
            nameAbrev = "GRE"
        }
        "Bragantino" -> {
            imageTime = R.drawable.icon_bragantino
            nameAbrev = "RBB"
        }
        "Fluminense" -> {
            imageTime = R.drawable.icon_fluminense
            nameAbrev ="FLU"
        }
        "Athletico-PR" -> {
            imageTime = R.drawable.icon_athletico_pr
            nameAbrev = "CAP"
        }
        "Flamengo" -> {
            imageTime = R.drawable.icon_flamengo
            nameAbrev = "FLA"
        }
        "Fortaleza" -> {
            imageTime = R.drawable.icon_fortaleza
            nameAbrev = "FOR"
        }
        "Atlético-MG" -> {
            imageTime = R.drawable.icon_atletico_mg
            nameAbrev = "CAM"

        }
        "São Paulo" -> {
            imageTime = R.drawable.icon_sao_paulo
            nameAbrev = "SAO"

        }
        "Corinthians" -> {
            imageTime = R.drawable.icon_corinthians
            nameAbrev = "COR"
        }
        "Cuiabá" -> {
            imageTime = R.drawable.icon_cuiaba
            nameAbrev = "CUI"
        }
        "Cruzeiro" -> {
            imageTime = R.drawable.icon_cruzeiro
            nameAbrev = "CRU"
        }
        "Internacional" -> {
            imageTime = R.drawable.icon_internacional
            nameAbrev = "INT"
        }
        "Vasco" -> {
            imageTime = R.drawable.icon_vasco_da_gama
            nameAbrev = "VAS"
        }
        "Goiás" -> {
            imageTime = R.drawable.icon_goias
            nameAbrev = "GOI"
        }
        "Bahia" -> {
            imageTime = R.drawable.icon_bahia
            nameAbrev = "BAH"
        }
        "Santos" -> {
            imageTime = R.drawable.icon_santos
            nameAbrev = "SAN"
        }
        "América-MG" -> {
            imageTime = R.drawable.icon_america_mg
            nameAbrev = "AME"
        }
        "Coritiba" -> {
            imageTime = R.drawable.icon_coritiba
            nameAbrev = "CFC"
        }

        else -> {
            imageTime = R.drawable.icon_error
            nameAbrev = "Algo deu errado, desculpe!"
        }
    }

    return listOf(imageTime, nameAbrev)

}
fun verificTimeSerieB(name: String): List<Any>{
    val imageTime: Int
    val nameAbrev: String

    when (name){
        "Vitória" -> {
            imageTime = R.drawable.icon_vitoria
            nameAbrev = "VIT"
        }
        "Criciúma" -> {
            imageTime = R.drawable.icon_criciuma
            nameAbrev = "CRI"
        }
        "Juventude" -> {
            imageTime = R.drawable.icon_juventude
            nameAbrev = "JUV"
        }
        "Atlético-GO" -> {
            imageTime = R.drawable.icon_atleticogo
            nameAbrev = "ACG"
        }
        "Sport" -> {
            imageTime = R.drawable.icon_sport_recife
            nameAbrev = "SPT"
        }
        "Vila Nova" -> {
            imageTime = R.drawable.icon_vila_nova
            nameAbrev = "VNO"
        }
        "Novorizontino" -> {
            imageTime = R.drawable.icon_novorizontino
            nameAbrev = "NOV"
        }
        "Mirassol" -> {
            imageTime = R.drawable.icon_mirassol
            nameAbrev = "MIR"
        }
        "Guarani" -> {
            imageTime = R.drawable.icon_guarani
            nameAbrev = "GUA"
        }
        "CRB" -> {
            imageTime = R.drawable.icon_crb
            nameAbrev = "CRB"
        }
        "Ceará" -> {
            imageTime = R.drawable.icon_ceara
            nameAbrev = "CEA"
        }
        "Botafogo-SP" -> {
            imageTime = R.drawable.icon_botafogo_sp
            nameAbrev = "BSP"
        }
        "Avaí" -> {
            imageTime = R.drawable.icon_avai
            nameAbrev = "AVA"
        }
        "Ituano" -> {
            imageTime = R.drawable.icon_ituano
            nameAbrev = "ITU"
        }
        "Ponte Preta" -> {
            imageTime = R.drawable.icon_ponte_preta
            nameAbrev = "PON"
        }
        "Tombense" -> {
            imageTime = R.drawable.icon_tombense
            nameAbrev = "TOM"
        }
        "Chapecoense" -> {
            imageTime = R.drawable.icon_chapecoense
            nameAbrev = "CHA"
        }
        "Sampaio Corrêa" -> {
            imageTime = R.drawable.icon_sampaio_correa
            nameAbrev = "SCO"
        }
        "Londrina" -> {
            imageTime = R.drawable.icon_londrina
            nameAbrev = "LEC"
        }
        "ABC" -> {
            imageTime = R.drawable.icon_abc
            nameAbrev = "ABC"
        }

        else -> {
            imageTime = R.drawable.icon_error
            nameAbrev = "ERR"
        }
    }

    return listOf(imageTime, nameAbrev)
}

fun verificTimeLaLiga(name: String): List<Any>{
    val imageTime: Int
    val nameAbrev: String

    when (name){
        "Girona" -> {
            imageTime = R.drawable.icon_girona
            nameAbrev = "GIR"
        }
        "Real Madrid" -> {
            imageTime = R.drawable.icon_real_madrid
            nameAbrev = "MAD"
        }
        "Barcelona" -> {
            imageTime = R.drawable.icon_barcelona
            nameAbrev = "BAR"
        }
        "Atlético de Madrid", "Atlético"  -> {
            imageTime = R.drawable.icon_atletico_madrid
            nameAbrev = "ATL"
        }
        "Athletic Bilbao", "Athletic"-> {
            imageTime = R.drawable.icon_athletic_bilbao
            nameAbrev = "ATH"
        }
        "Real Sociedad" -> {
            imageTime = R.drawable.icon_real_sociedad
            nameAbrev = "RSO"
        }
        "Betis", "Real Betis" -> {
            imageTime = R.drawable.icon_betis
            nameAbrev = "BET"
        }
        "Las Palmas" -> {
            imageTime = R.drawable.icon_la_palmas
            nameAbrev = "LPA"
        }
        "Valencia" -> {
            imageTime = R.drawable.icon_valencia
            nameAbrev = "VAL"
        }
        "Rayo Vallecano" -> {
            imageTime = R.drawable.icon_rayo_vallecano
            nameAbrev = "RVL"
        }
        "Getafe" -> {
            imageTime = R.drawable.icon_getafe
            nameAbrev = "GET"
        }
        "Osasuna" -> {
            imageTime = R.drawable.icon_osasuna
            nameAbrev = "OSA"
        }
        "Sevilla" -> {
            imageTime = R.drawable.icon_sevilla
            nameAbrev = "SEV"
        }
        "Villarreal" -> {
            imageTime = R.drawable.icon_villar_real
            nameAbrev = "VIL"
        }
        "Alavés" -> {
            imageTime = R.drawable.icon_alaves
            nameAbrev = "ALV"
        }
        "Cádiz" -> {
            imageTime = R.drawable.icon_cadiz
            nameAbrev = "CAD"
        }
        "Mallorca" -> {
            imageTime = R.drawable.icon_mallorca
            nameAbrev = "MLC"
        }
        "Celta" -> {
            imageTime = R.drawable.icon_celta
            nameAbrev = "CVI"
        }
        "Granada" -> {
            imageTime = R.drawable.icon_granada
            nameAbrev = "GRA"
        }
        "Almería" -> {
            imageTime = R.drawable.icon_almeria
            nameAbrev = "ALM"
        }

        else -> {
            imageTime = R.drawable.icon_error
            nameAbrev = "ERR"
        }
    }

    return listOf(imageTime, nameAbrev)
}

fun verificTimePremier(name: String): List<Any>{
    val imageTime: Int
    val nameAbrev: String

    when (name){
        "Manchester City" -> {
            imageTime = R.drawable.icon_manchester_city
            nameAbrev = "MAC"
        }
        "Liverpool" -> {
            imageTime = R.drawable.icon_liverpool
            nameAbrev = "LIV"
        }
        "Arsenal" -> {
            imageTime = R.drawable.icon_arsenal
            nameAbrev = "ARS"
        }
        "Tottenham" -> {
            imageTime = R.drawable.icon_tottenham
            nameAbrev = "TOT"
        }
        "Aston Villa" -> {
            imageTime = R.drawable.icon_aston_villa
            nameAbrev = "ASV"
        }
        "Manchester United" -> {
            imageTime = R.drawable.icon_manchester_united
            nameAbrev = "MAN"
        }
        "Newcastle" -> {
            imageTime = R.drawable.icon_newcastle
            nameAbrev = "NEW"
        }
        "Brighton" -> {
            imageTime = R.drawable.icon_brighton
            nameAbrev = "BFC"
        }
        "West Ham" -> {
            imageTime = R.drawable.icon_west_ham
            nameAbrev = "WTH"
        }
        "Chelsea" -> {
            imageTime = R.drawable.icon_chelsea
            nameAbrev = "CHE"
        }
        "Brentford" -> {
            imageTime = R.drawable.icon_brentford
            nameAbrev = "BRE"
        }
        "Wolverhampton" -> {
            imageTime = R.drawable.icon_wolverhampton
            nameAbrev = "WOL"
        }
        "Crystal Palace" -> {
            imageTime = R.drawable.icon_crystal_palace
            nameAbrev = "CPA"
        }
        "Nottingham Forest" -> {
            imageTime = R.drawable.icon_nottingham_forest
            nameAbrev = "NOT"
        }
        "Fulham" -> {
            imageTime = R.drawable.icon_fulham
            nameAbrev = "FUL"
        }
        "Bournemouth" -> {
            imageTime = R.drawable.icon_bournemouth
            nameAbrev = "BOU"
        }
        "Luton Town" -> {
            imageTime = R.drawable.icon_luton_town
            nameAbrev = "LUT"
        }
        "Sheffield United" -> {
            imageTime = R.drawable.icon_sheffield_united
            nameAbrev = "SHU"
        }
        "Everton" -> {
            imageTime = R.drawable.icon_everton
            nameAbrev = "EVE"
        }
        "Burnley" -> {
            imageTime = R.drawable.icon_burnley
            nameAbrev = "BUR"
        }

        else -> {
            imageTime = R.drawable.icon_error
            nameAbrev = "ERR"
        }
    }

    return listOf(imageTime, nameAbrev)
}
