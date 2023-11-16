package com.futebolplacar.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.R
import com.futebolplacar.datasource.Artilharia
import com.futebolplacar.viewModel.ViewModelFut

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun selectCampeonato(viewModel: ViewModelFut, naveController: NavController){

    viewModel.setConfigView("selectCampeonato")

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
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()


                            viewModel.setCampeonatoAtual("Brasileiro A")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")
                        })

                Image(painterResource(id = R.drawable.logo_brasileirao_b),
                    contentDescription = "Image Brasileira B",
                    modifier = Modifier
                        .clickable {
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()

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
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()


                            viewModel.setCampeonatoAtual("La Liga")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")

                        })

                Image(painterResource(id = R.drawable.logo_premier),
                    contentDescription = "Image Premier",
                    modifier = Modifier
                        .clickable {
                            viewModel.classificacaoGeral.value.clear()
                            viewModel.artilharia.value.artilheiros = mutableListOf()
                            viewModel.jogosDaRodada.value.clear()


                            viewModel.setCampeonatoAtual("Premier")
                            viewModel.setFirestore(viewModel, "classficicacaoGeral")
                            naveController.navigate("classificacaoGeralCompose")

                        })
            }
        }


}