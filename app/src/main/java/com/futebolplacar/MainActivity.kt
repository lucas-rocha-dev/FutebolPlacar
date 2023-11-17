package com.futebolplacar

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.futebolplacar.adMob.AdMob
import com.futebolplacar.compose.PoliticPrivac
import com.futebolplacar.compose.artilhariaCompose
import com.futebolplacar.compose.classificacaoGeralCompose
import com.futebolplacar.compose.columnavegationCompose
import com.futebolplacar.compose.navegationBar
import com.futebolplacar.compose.rodadasCompose
import com.futebolplacar.compose.selectCampeonato
import com.futebolplacar.compose.topBar
import com.futebolplacar.ui.theme.FutebolPlacarTheme
import com.futebolplacar.viewModel.ViewModelFut


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            FutebolPlacarTheme {

                val viewModel by viewModels<ViewModelFut>()

                val navController = rememberNavController()

                val context = LocalContext.current

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier

                    .fillMaxSize(),
                ) {
                    Box(modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFF092B0B), Color(0xFF195E1B)),
                                startX = 0f,
                                endX = 1000f
                            )
                        )
                        .fillMaxSize()
                        .fillMaxSize(),

                        contentAlignment = Alignment.TopStart,

                        ) {

                        Column {


                                topBar(viewModel)


                            Box(modifier = Modifier.fillMaxSize() ){

                                val interactionSource = remember { MutableInteractionSource() }
                                Column(modifier = Modifier
                                    .clickable(
                                        interactionSource = interactionSource,
                                        indication = null
                                    ) { Armazem.columView = false }
                                    .padding(
                                        bottom = 130.dp
                                    )) {
                                    if(!Armazem.selectCampeonato) {
                                        navegationBar(navController, viewModel)
                                    }

                                    MyAppNavHost(navController, context, viewModel)
                                }
                                if (Armazem.columView){
                                    Box(modifier = Modifier.padding(start = 20.dp)){
                                        columnavegationCompose(navController, context)

                                    }
                                }
                                Box(modifier = Modifier
                                    .heightIn(max = 400.dp)
                                    .padding(top = 40.dp)
                                    .align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                ) {
                                    AdMob()
                                }
                            }
                        }
                    }

                }

            }

        }

    }

}

@Composable
fun MyAppNavHost(
    navController: NavHostController,
    context: Context,
    viewModel: ViewModelFut,
    startDestination: String = "selectCampeonato"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("classificacaoGeralCompose") {
            classificacaoGeralCompose(viewModel)
        }

        composable("rodadasCompose") { rodadasCompose(viewModel) }

        composable("artilhariaCompose") {artilhariaCompose(viewModel)}

        composable("PoliticPrivac") {PoliticPrivac(viewModel)}

        composable("selectCampeonato") {selectCampeonato(viewModel, navController)}

    }
}
