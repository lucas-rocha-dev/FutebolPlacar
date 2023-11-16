package com.futebolplacar.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.viewModel.ViewModelFut
import kotlinx.coroutines.delay

@Composable
fun carregandoServeCompose(naveController: NavController, viewModel: ViewModelFut) {
    val carregamentoServe by viewModel.carregandoServe.collectAsState()

    if(carregamentoServe) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Carregando..", fontSize = 35.sp, color = Color.White)

        }
        LaunchedEffect(carregamentoServe) {
            delay(3000)
            naveController.navigate("classificacaoGeralCompose")

        }

    } else {
        naveController.navigate("selectCampeonato")

    }

}