package com.futebolplacar.compose

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.futebolplacar.datasource.ClassificacaoGeralA
import com.futebolplacar.firestore.organizeRank
import com.futebolplacar.funCompose.iconLaLiga
import com.futebolplacar.funCompose.iconPremier
import com.futebolplacar.funCompose.iconSerieA
import com.futebolplacar.funCompose.iconSerieB
import com.futebolplacar.funCompose.verificTime
import com.futebolplacar.viewModel.ViewModelFut


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun classificacaoGeralCompose(viewModel: ViewModelFut){
    viewModel.setConfigView("classificacaoGeralCompose")


    val listClassificacaoGeral  by viewModel.classificacaoGeral.collectAsState()


    if (listClassificacaoGeral.size < 2){
        Text(modifier = Modifier.padding(top = 40.dp, start = 60.dp),text = "Carregando...",
            fontSize = 30.sp, color = Color.White)
    }






    LazyColumn(modifier = Modifier
        .padding(start = 2.dp)
        .fillMaxSize()
    ) {
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp))
            topPontuacao()
        }

        itemsIndexed(listClassificacaoGeral) { index, time ->


            ClassificacaoGeralItem(time, index, viewModel)
        }
 }




}
@Composable
fun ClassificacaoGeralItem(classificacao: ClassificacaoGeralA, index: Int, viewModel: ViewModelFut) {
 val (icone_time, nameAbrev) = verificTime(classificacao.name_time, viewModel)
 var posicao_time = index +1
 var color_colocacao = Color.White
 if(posicao_time < 5){
     color_colocacao = Color.Green
 }
 if(posicao_time > 16){
     color_colocacao = Color.Red
 }
 Row(modifier = Modifier
     .fillMaxWidth()) {

    Text(text = "$posicao_time" +"º", color = color_colocacao, fontSize = 10.sp)

   Image(modifier = Modifier.size(30.dp, 30.dp),
   painter = painterResource(id = icone_time as Int),
   contentDescription = "Bandeira Time" )

  Text(text = "$nameAbrev", color = Color.White,fontWeight = FontWeight.Bold)

  Row(modifier = Modifier
      .padding(top = 3.dp)
      .fillMaxWidth(),
   horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {

    Box(modifier = Modifier.width(30.dp)){
        Text(text = "${classificacao.P}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)
    }

   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.J}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)
   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.V}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)
   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.E}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.D}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.GP}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.GC}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.SG}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }
   Box(modifier = Modifier.width(30.dp)){
    Text(text = "${classificacao.porcentagem}", color = Color.White,fontWeight = FontWeight.Bold, fontSize = 12.sp)

   }

  }
 }
    Divider(
        color = Color.White,
        modifier = Modifier.padding(top = 2.dp, bottom =  2.dp)
    )

}


@Preview
@Composable
fun topPontuacao(){
  Row(horizontalArrangement = Arrangement.End,
   modifier = Modifier
       .fillMaxWidth()
  )
        {

   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "P", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

}
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "J", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "V", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "E", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "D", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "GP", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "GC", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "SG", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }
   Box(modifier = Modifier.width(30.dp)) {
    Text(text = "%", style = TextStyle(Color.White, fontSize = 12.sp),fontWeight = FontWeight.Bold)

   }


  }
}




