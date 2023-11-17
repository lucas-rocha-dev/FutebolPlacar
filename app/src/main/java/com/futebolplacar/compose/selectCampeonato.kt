package com.futebolplacar.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.R
import com.futebolplacar.viewModel.ViewModelFut


@Composable
fun selectCampeonato(viewModel: ViewModelFut, naveController: NavController){
   var checkName by remember { mutableStateOf(true) }
    viewModel.setConfigView("selectCampeonato")

    if (checkName){
        viewModel.setNameWindow("Futebol Placar")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Selecione o Campeonato",
                color = Color.White,
                fontSize = 27.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 35.dp)
            )

            //Brasileirao A e B
            Row {
                Image(painterResource(id = R.drawable.logo_brasileirao_a),
                    contentDescription = "Image Brasileira A",
                    modifier = Modifier
                        .clickable {
                            checkName = false
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()

                            viewModel.setNameWindow("Brasileirão Série A")

                            viewModel.setCampeonatoAtual("Brasileiro A")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")
                        })

                Image(painterResource(id = R.drawable.logo_brasileirao_b),
                    contentDescription = "Image Brasileira B",
                    modifier = Modifier
                        .clickable {
                            checkName = false
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()

                            viewModel.setNameWindow("Brasileirão Série B")


                            viewModel.setCampeonatoAtual("Brasileiro B")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")

                        })
            }
            //La Liga e Premier
            Row {
                Image(painterResource(id = R.drawable.logo_la_liga),
                    contentDescription = "Image La Liga",
                    modifier = Modifier
                        .clickable {
                            checkName = false
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()


                            viewModel.setNameWindow("La Liga")


                            viewModel.setCampeonatoAtual("La Liga")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")

                        })

                Image(painterResource(id = R.drawable.logo_premier),
                    contentDescription = "Image Premier",
                    modifier = Modifier
                        .clickable {
                            checkName = false
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()


                            viewModel.setNameWindow("Premier League")

                            viewModel.setCampeonatoAtual("Premier")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")

                        })
            }
        }


}