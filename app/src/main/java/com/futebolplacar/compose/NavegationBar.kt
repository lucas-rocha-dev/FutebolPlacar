package com.futebolplacar.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.R
import com.futebolplacar.countInterstitial
import com.futebolplacar.viewModel.ViewModelFut

@Composable
fun NavegationBar(navController: NavController, viewModel: ViewModelFut){


    val colorGeral = viewModel.colorSelectGeral.collectAsState().value
    val colorRodadas = viewModel.colorSelectRodadas.collectAsState().value
    val colorArtilheiros = viewModel.colorSelectArtilheiros.collectAsState().value

    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()) {

                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .width(100.dp)
                        .height(50.dp)
                        .clickable {
                            countInterstitial++

                            viewModel.selectColorNav("Geral")
                            navController.navigate("classificacaoGeralCompose")

                        }
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = colorGeral,
                                startX = 0f,
                                endX = 1000f
                            )
                        )
                        .border(0.05.dp, Color.Green)
                        ) {
                    Image(painterResource(id = R.drawable.icon_trofeu),
                        contentDescription = "Classificacao Geral",
                        modifier = Modifier.size(40.dp,30.dp)
                        )
                    Text(text = "Classificação Geral", color = Color.White, fontSize = 10.sp)
                }

     //-------------------------------------------------------------------------------------

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 5.dp)
                .width(100.dp)
                .height(50.dp)
                .clickable {

                    countInterstitial++

                    if (viewModel.jogosDaRodada.value.size < 1) {
                        viewModel.setFirestore(viewModel, "rodadas")

                    }
                    viewModel.selectColorNav("Rodadas")

                    navController.navigate("rodadasCompose")
                }
                .background(
                    brush = Brush.horizontalGradient(
                        colors = colorRodadas,
                        startX = 0f,
                        endX = 1000f
                    )
                )
                .border(0.05.dp, Color.Green)
        ) {
            Image(painterResource(id = R.drawable.icon_bola),
                contentDescription = "Rodadas",
                modifier = Modifier.size(40.dp,30.dp)
            )
            Text(text = "Jogos da Rodada", color = Color.White, fontSize = 10.sp)
        }
    //-------------------------------------------------------------------------------------
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 5.dp)
                .width(100.dp)
                .height(50.dp)
                .clickable {

                    countInterstitial++

                    if (viewModel.artilharia.value.artilheiros.isEmpty()) {
                        viewModel.setFirestore(viewModel, "artilharia")

                    }
                    navController.navigate("artilhariaCompose")

                    viewModel.selectColorNav("Artilheiros")


                }
                .background(
                    brush = Brush.horizontalGradient(
                        colors = colorArtilheiros,
                        startX = 0f,
                        endX = 1000f
                    )
                )
                .border(0.05.dp, Color.Green)
        ) {
            Image(painterResource(id = R.drawable.icon_estatistica),
                contentDescription = "Artilharia",
                modifier = Modifier.size(40.dp,30.dp)
            )
            Text(text = "Artilharia", color = Color.White, fontSize = 10.sp)
        }

    }
}