package com.futebolplacar.compose


import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.futebolplacar.Armazem
import com.futebolplacar.R

@Composable
fun columnavegationCompose(navController: NavController, context: Context){

    Column(modifier = Modifier
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(Color(0xFF092B0B), Color(0xFF195E1B)),
                startX = 0f,
                endX = 1000f
            )
        )
        .border(0.5.dp, Color.Green)
        .padding(top = 10.dp, start = 10.dp, end = 10.dp))
         {

        Row(modifier = Modifier
            .clickable { navController.navigate("selectCampeonato")
                Armazem.columView = false
            })
        {
            Image(painterResource(id = R.drawable.icon_trofeu),
                contentDescription = "Seleção de Campeonato",
                modifier = Modifier.size(40.dp,30.dp)
            )

            Text(text = "Seleção de Campeonato", color = Color.White, fontSize = 20.sp)

        }







        Row(modifier = Modifier
            .clickable {
                navController.navigate("PoliticPrivac")
                Armazem.columView = false


            }
            .padding(top = 10.dp)) {
            Image(painterResource(id = R.drawable.icon_politica),
                contentDescription = "Politica de Privacidade",
                modifier = Modifier
                    .size(40.dp, 40.dp)
            )
            Text(text = "Politica Privacidade", color = Color.White, fontSize = 20.sp,
                modifier = Modifier.padding(start = 4.dp))
        }


        Row(modifier = Modifier
            .clickable {
                Armazem.columView = false
                (context as? Activity)?.finish()
            }
            .padding(top = 10.dp, bottom = 10.dp)) {
            Image(painterResource(id = R.drawable.icon_sair),
                contentDescription = "Sair",
                modifier = Modifier
                    .padding(start = 7.dp)
                    .size(20.dp, 30.dp)
            )
            Text(text = "Sair", color = Color.White, fontSize = 20.sp,
                modifier = Modifier.padding(start = 14.dp))
        }
    }

}
