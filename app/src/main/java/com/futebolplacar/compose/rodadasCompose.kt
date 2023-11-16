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
import com.futebolplacar.Armazem
import com.futebolplacar.R
import com.futebolplacar.datasource.Jogo
import com.futebolplacar.datasource.RodadasA
import com.futebolplacar.funCompose.verificIcon
import com.futebolplacar.viewModel.ViewModelFut


@Composable
fun rodadasCompose(viewModel: ViewModelFut){
   viewModel.setNameWindow("Rodadas Série A")


   //val armazemRodadasA = Armazem.jogosDaRodada
    val getRodadas by viewModel.jogosDaRodada.collectAsState()
    val n_rodada by viewModel.nRodada.collectAsState()

   val classificacaoGeralA = getRodadas.sortedBy { it.n_rodada.toInt() }
    if(classificacaoGeralA.size > 2){
        rodadasFilter(classificacaoGeralA, n_rodada, viewModel)
    } else {
        Text(modifier = Modifier.padding(top = 40.dp, start = 60.dp),text = "Carregando...",
            fontSize = 30.sp, color = Color.White)
    }


}

@Composable
fun rodadasFilter(rodadas: List<RodadasA>, rodadaAtual: Int, viewModel: ViewModelFut){
   val rodadaView = rodadas[rodadaAtual].jogos.sortedBy { it.n_jogo.toInt() }

    LazyColumn(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        item { rodadaBar(rodadaAtual, viewModel) }

        itemsIndexed(rodadaView){  index, item ->
            rodadasView(item)

    }
 }
}
@Composable
fun rodadasView(jogos: Jogo){

    val imgTimeA = verificIcon(jogos.Time_A)
    val imgTimeB = verificIcon(jogos.Time_B)
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

    Text(text = jogos.data_local,
        color = Color.White, fontSize = 10.sp,
        modifier = Modifier.
    padding(top = 5.dp, bottom = 5.dp))

    Row {
        Text(text = jogos.Time_A, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

        Image(modifier = Modifier.size(30.dp, 30.dp),
            painter = painterResource(id = imgTimeA),
            contentDescription = "Bandeira Time" )

        Text(text = jogos.Gols_A, color = Color.White,
            modifier = Modifier.
        padding(start = 3.dp, end = 3.dp))

        Text(text = "X", color = Color.White)

        Text(text = jogos.Gols_B, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

        Image(modifier = Modifier.size(30.dp, 30.dp),
            painter = painterResource(id = imgTimeB),
            contentDescription = "Bandeira Time" )

        Text(text = jogos.Time_B, color = Color.White,
            modifier = Modifier.
            padding(start = 3.dp, end = 3.dp))

    }
    }


}


@Composable
fun rodadaBar(rodadaAtual: Int, viewModel: ViewModelFut){
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
                    .size(30.dp)
                    .clickable { clickRodadaBack(1, rodadaAtual, viewModel) },
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
                    .size(30.dp)
                    .graphicsLayer(
                        scaleX = remember { -1f }
                    )
                    .clickable { clickRodadaProx(1, rodadaAtual, viewModel) }

            )
        }
}
fun clickRodadaProx(valor: Int, rodadaAtual: Int, viewModel: ViewModelFut){
    if(rodadaAtual < 37){
        viewModel.setNrodada(rodadaAtual + valor)
        Log.i("n_rodada", rodadaAtual.toString())

    } else {
        Log.i("n_rodada", rodadaAtual.toString() + "valor maior ou igual 39")

    }


}
fun clickRodadaBack(valor: Int, rodadaAtual: Int, viewModel: ViewModelFut){
    if(rodadaAtual > 0){
        viewModel.setNrodada(rodadaAtual - valor)
        Log.i("n_rodada", rodadaAtual.toString())

    } else {
        Log.i("n_rodada", rodadaAtual.toString() + "numero da rodada menor que >=1")

    }


}

