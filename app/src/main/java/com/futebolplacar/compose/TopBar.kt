package com.futebolplacar.compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.Armazem
import com.futebolplacar.Armazem.lastClickTime
import com.futebolplacar.funCompose.verificLogoCampeonato
import com.futebolplacar.viewModel.ViewModelFut


@Composable
fun TopBar(viewModel: ViewModelFut, naveController: NavController){

    val nameWindow by viewModel.nameWindow.collectAsState()
    val logoCampeonato = verificLogoCampeonato(nameWindow)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
        ) {

        Icon(modifier = Modifier
            .clickable {
                Armazem.columView = !Armazem.columView

            }
            .padding(start = 10.dp)
            .size(40.dp)
            .scale(1f),
            imageVector = Icons.Default.Menu,
            tint = Color.White,
            contentDescription = "menu superior")

        Text(text = nameWindow, color = Color.White, fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp, end = 10.dp),
            textAlign = TextAlign.Center)

        Image(painterResource(id = logoCampeonato),
            contentDescription = "Logo Campeonato",
            modifier = Modifier.size(40.dp, 40.dp))

            Column(modifier = Modifier
            .padding(end = 5.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End) {


            if(!Armazem.selectCampeonato) {



            IconButton(
                onClick = {

                if (System.currentTimeMillis() - lastClickTime > 30000) {
                    lastClickTime = System.currentTimeMillis()

                    viewModel.classificacaoGeral.value.clear()
                    viewModel.artilharia.value.artilheiros = mutableListOf()
                    viewModel.jogosDaRodada.value.clear()

                    viewModel.setFirestore(viewModel, "classficicacaoGeral")
                    naveController.navigate("classificacaoGeralCompose")

                    Log.d("Click", "Click")

                } else {
                    Log.d("Click", "intervalo click")
                }

                }
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Default.Refresh,
                    tint = Color.White,
                    contentDescription = "Atualizar"
                )
            }


            }

         }

        }
    }
}