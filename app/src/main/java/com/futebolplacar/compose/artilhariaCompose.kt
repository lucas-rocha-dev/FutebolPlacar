package com.futebolplacar.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.futebolplacar.Armazem
import androidx.compose.ui.unit.sp
import com.futebolplacar.datasource.Posicao
import com.futebolplacar.funCompose.verificIcon
import com.futebolplacar.viewModel.ViewModelFut


@Composable
fun artilhariaCompose(viewModel: ViewModelFut){
    viewModel.setNameWindow("Artilharia")


    //val artilharia = Armazem.artilharia.artilheiros.sortedBy { it.rank.toInt() }
    val artilhariaGet by viewModel.artilharia.collectAsState()
    val artilharia = artilhariaGet.artilheiros.sortedBy { it.rank.toInt() }

    LazyColumn(
        Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()) {

        itemsIndexed(artilharia){ index, item ->
            artilhariaView(item)
        }
    }

}

@Composable
fun artilhariaView(jogador: Posicao){
    val img_time = verificIcon(jogador.time)
    var n_posicao = jogador.rank
    if(n_posicao.toInt() > 5){
        n_posicao = "  "
    }

    Row(modifier = Modifier
        .fillMaxWidth()) {
        Text(text = n_posicao, fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier

                .padding(start = 2.dp))

        Image(painterResource(id = img_time),
            contentDescription = "Imagem Time",
            modifier = Modifier
                .padding(start = 10.dp)
                .size(30.dp, 30.dp))

        Text(text = jogador.jogador, fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start =3.dp))

        Box(
            Modifier
                .padding(end = 3.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd,
            ) {
            Text(textAlign = TextAlign.End,
                text = jogador.gols, fontSize = 20.sp,
                color = Color.White,
            )
        }

    }
    Divider(
        color = Color.White,
        thickness = 0.2.dp,
        modifier = Modifier.padding(top = 1.dp, bottom =  1.dp)
    )

}