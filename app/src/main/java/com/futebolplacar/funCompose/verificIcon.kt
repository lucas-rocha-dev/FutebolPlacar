package com.futebolplacar.funCompose


import com.futebolplacar.R
import com.futebolplacar.viewModel.ViewModelFut

fun verificIcon(name: String, viewModel: ViewModelFut): Int{
    val imageTime: Int
    val campeonato = viewModel.campeonato.value

    when(campeonato) {
        "Brasileiro A" -> imageTime = iconSerieA(name)
        "Brasileiro B" -> imageTime = iconSerieB(name)
        "La Liga" -> imageTime = iconLaLiga(name)
        "Premier" -> imageTime = iconPremier(name)
        else -> imageTime = R.drawable.icon_error
    }

    return imageTime

}
fun iconSerieA(name: String): Int{

    val imageTime: Int

    when (name) {
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

        else -> {
            imageTime = R.drawable.icon_error

        }
    }
    return imageTime
}

fun iconSerieB(name: String): Int{
    val imageTime: Int
    when(name){
        "Vitória", "VIT" -> imageTime = R.drawable.icon_vitoria
        "Criciúma", "CRI" -> imageTime = R.drawable.icon_criciuma
        "Juventude", "JUV" -> imageTime = R.drawable.icon_juventude
        "Atlético-GO", "ACG" -> imageTime = R.drawable.icon_atleticogo
        "Sport", "SPT" -> imageTime = R.drawable.icon_sport_recife
        "Vila Nova", "VNO" -> imageTime = R.drawable.icon_vila_nova
        "Novorizontino", "NOV" -> imageTime = R.drawable.icon_novorizontino
        "Mirassol", "MIR" -> imageTime = R.drawable.icon_mirassol
        "Guarani", "GUA" -> imageTime = R.drawable.icon_guarani
        "CRB" -> imageTime = R.drawable.icon_crb
        "Ceará", "CEA" -> imageTime = R.drawable.icon_ceara
        "Botafogo-SP", "BSP" -> imageTime = R.drawable.icon_botafogo_sp
        "Avaí", "AVA" -> imageTime = R.drawable.icon_avai
        "Ituano", "ITU" -> imageTime = R.drawable.icon_ituano
        "Ponte Preta", "PON" -> imageTime = R.drawable.icon_ponte_preta
        "Tombense", "TOM" -> imageTime = R.drawable.icon_tombense
        "Chapecoense", "CHA" -> imageTime = R.drawable.icon_chapecoense
        "Sampaio Corrêa", "SCO" -> imageTime = R.drawable.icon_sampaio_correa
        "Londrina", "LEC"-> imageTime = R.drawable.icon_londrina
        "ABC" -> imageTime = R.drawable.icon_abc

        else -> imageTime = R.drawable.icon_error
    }
    return imageTime
}

fun iconLaLiga(name:String):Int{
    val imageTime: Int

    when(name) {

        "Girona", "GIR" -> imageTime = R.drawable.icon_girona
        "Real Madrid", "MAD" -> imageTime = R.drawable.icon_real_madrid
        "Barcelona", "BAR" -> imageTime = R.drawable.icon_barcelona
        "Atlético de Madrid", "ATL", "Atlético"  -> imageTime = R.drawable.icon_atletico_madrid
        "Athletic Bilbao", "ATH" , "Athletic"-> imageTime = R.drawable.icon_athletic_bilbao
        "Real Sociedad","RSO" -> imageTime = R.drawable.icon_real_sociedad
        "Betis", "BET", "Real Betis" -> imageTime = R.drawable.icon_betis
        "Las Palmas","LPA" -> imageTime = R.drawable.icon_la_palmas
        "Valencia", "VAL" -> imageTime = R.drawable.icon_valencia
        "Rayo Vallecano", "RVL" -> imageTime = R.drawable.icon_rayo_vallecano
        "Getafe", "GET" -> imageTime = R.drawable.icon_getafe
        "Osasuna","OSA" -> imageTime = R.drawable.icon_osasuna
        "Sevilla", "SEV" -> imageTime = R.drawable.icon_sevilla
        "Villarreal" ,"VIL" -> imageTime = R.drawable.icon_villar_real
        "Alavés", "ALV" -> imageTime = R.drawable.icon_alaves
        "Cádiz", "CAD" -> imageTime = R.drawable.icon_cadiz
        "Mallorca", "MLC" -> imageTime = R.drawable.icon_mallorca
        "Celta", "CVI", -> imageTime = R.drawable.icon_celta
        "Granada", "GRA" -> imageTime = R.drawable.icon_granada
        "Almería", "ALM" -> imageTime = R.drawable.icon_almeria

        else -> imageTime = R.drawable.icon_error

    }
    return imageTime
}

fun iconPremier(teamName: String): Int {
    return when (teamName) {
        "Manchester City", "MAC" -> R.drawable.icon_manchester_city
        "Liverpool", "LIV" -> R.drawable.icon_liverpool
        "Arsenal", "ARS" -> R.drawable.icon_arsenal
        "Tottenham", "TOT" -> R.drawable.icon_tottenham
        "Aston Villa", "ASV" -> R.drawable.icon_aston_villa
        "Manchester United", "MAN" -> R.drawable.icon_manchester_united
        "Newcastle", "NEW" -> R.drawable.icon_newcastle
        "Brighton", "BFC" -> R.drawable.icon_brighton
        "West Ham", "WTH" -> R.drawable.icon_west_ham
        "Chelsea", "CHE" -> R.drawable.icon_chelsea
        "Brentford", "BRE" -> R.drawable.icon_brentford
        "Wolverhampton", "WOL" -> R.drawable.icon_wolverhampton
        "Crystal Palace", "CPA" -> R.drawable.icon_crystal_palace
        "Nottingham Forest", "NOT" -> R.drawable.icon_nottingham_forest
        "Fulham", "FUL" -> R.drawable.icon_fulham
        "Bournemouth", "BOU" -> R.drawable.icon_bournemouth
        "Luton Town", "LUT" -> R.drawable.icon_luton_town
        "Sheffield United", "SHU" -> R.drawable.icon_sheffield_united
        "Everton", "EVE" -> R.drawable.icon_everton
        "Burnley", "BUR" -> R.drawable.icon_burnley

        else -> R.drawable.icon_error
    }
}