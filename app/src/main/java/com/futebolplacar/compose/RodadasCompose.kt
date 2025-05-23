package com.futebolplacar.compose

import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.futebolplacar.R
import com.futebolplacar.datasource.Jogo
import com.futebolplacar.datasource.RodadasA
import com.futebolplacar.funCompose.verificIcon
import com.futebolplacar.viewModel.ViewModelFut


@Composable
fun RodadasCompose(viewModel: ViewModelFut){

    val getRodadas by viewModel.jogosDaRodada.collectAsState()
    val nRodada by viewModel.nRodada.collectAsState()

   val rodadasView = getRodadas.sortedBy { it.nRodada.toInt() }

   if(rodadasView.isNotEmpty()){
        RodadasFilter(rodadasView, nRodada, viewModel)
    } else {
        Text(modifier = Modifier.padding(top = 40.dp, start = 60.dp),text = "Carregando...",
            fontSize = 30.sp, color = Color.White)
    }


}

@Composable
fun RodadasFilter(rodadas: List<RodadasA>, rodadaAtual: Int, viewModel: ViewModelFut){
   val rodadaView = rodadas[0].jogos.sortedBy { it.nJogo.toInt() }

    LazyColumn(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        item { RodadaBar(rodadaAtual, viewModel) }

        itemsIndexed(rodadaView){  _, item ->
            RodadasView(item, viewModel)

    }
 }
}
@Composable
fun RodadasView(jogos: Jogo, viewModel: ViewModelFut){

    val imgTimeA = verificIcon(jogos.timeA, viewModel)
    val imgTimeB = verificIcon(jogos.timeB, viewModel)
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 7.dp)
            .width(300.dp)
            .height(70.dp)
            .padding(start = 10.dp, end = 10.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFF092B0B), Color(0xFF195E1B)),
                    startX = 0f,
                    endX = 1000f
                )
            )
            .border(0.05.dp, Color(0xFF092B0B))



    ){

    Text(text = jogos.dataLocal,
        color = Color.White, fontSize = 10.sp,
        modifier = Modifier.
    padding(top = 5.dp, bottom = 5.dp))

    Row {
        Text(text = jogos.timeA, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

        Image(modifier = Modifier.size(30.dp, 30.dp),
            painter = painterResource(id = imgTimeA),
            contentDescription = "Bandeira Time" )

        Text(text = jogos.golsA, color = Color.White,
            modifier = Modifier.
        padding(start = 3.dp, end = 3.dp))

        Text(text = "X", color = Color.White)

        Text(text = jogos.golsB, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

        Image(modifier = Modifier.size(30.dp, 30.dp),
            painter = painterResource(id = imgTimeB),
            contentDescription = "Bandeira Time" )

        Text(text = jogos.timeB, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

    }
    }


}


@Composable
fun RodadaBar(rodadaAtual: Int, viewModel: ViewModelFut){
    val numeroRodada = rodadaAtual + 1
    Row(verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()

        ) {

            Image(painterResource(id = R.drawable.icon_seta),
                contentDescription ="seta voltar",
                modifier = Modifier
                    .padding(start = 15.dp, top = 10.dp)
                    .size(30.dp)
                    .clickable { clickRodadaBack(numeroRodada, viewModel) },
                alignment = Alignment.TopStart

            )
            Text(text = "Rodada $numeroRodada",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier
                    .weight(1f)
            )

            Image(painterResource(id = R.drawable.icon_seta),
                contentDescription ="seta proxima",
                modifier = Modifier
                    .padding(end = 15.dp, top = 10.dp)
                    .size(30.dp)
                    .graphicsLayer(
                        scaleX = remember { -1f }
                    )
                    .clickable { clickRodadaProx(numeroRodada, viewModel) }

            )
        }
}

fun clickRodadaProx(rodadaAtual: Int, viewModel: ViewModelFut){
    if(rodadaAtual < 38){
        val nRodada = viewModel.nRodada.value + 1
        viewModel.setNrodada(nRodada)

        viewModel.setFirestore(viewModel, "rodadas click")

    } else {
        Log.i("n_rodada", rodadaAtual.toString() + "valor maior ou igual 39")

    }


}
fun clickRodadaBack(rodadaAtual: Int, viewModel: ViewModelFut){
    if(rodadaAtual > 1){
        val nRodada = viewModel.nRodada.value - 1
        viewModel.setNrodada(nRodada)

        viewModel.setFirestore(viewModel, "rodadas click")


    } else {
        Log.i("n_rodada", rodadaAtual.toString() + "numero da rodada menor que >=1")

    }


}

